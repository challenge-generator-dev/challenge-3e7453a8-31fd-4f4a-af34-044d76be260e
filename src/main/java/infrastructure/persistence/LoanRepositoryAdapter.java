package infrastructure.persistence;

import domain.model.Loan;
import domain.port.LoanRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class LoanRepositoryAdapter implements LoanRepository {

    private final LoanJpaRepository jpaRepository;

    public LoanRepositoryAdapter(LoanJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Loan save(Loan loan) {
        LoanEntity entity = toEntity(loan);
        LoanEntity saved = jpaRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Optional<Loan> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public void deleteById(UUID id) {
        jpaRepository.deleteById(id);
    }

    public Optional<Loan> findByCustomerId(String customerId) {
        return jpaRepository.findByCustomerId(customerId).map(this::toDomain);
    }

    public List<Loan> findByStatus(Loan.LoanStatus status) {
        return jpaRepository.findByStatus(status.name()).stream()
                .map(this::toDomain)
                .toList();
    }

    public List<Loan> findByAmountBetween(BigDecimal minAmount, BigDecimal maxAmount) {
        return jpaRepository.findByAmountBetween(minAmount, maxAmount).stream()
                .map(this::toDomain)
                .toList();
    }

    private LoanEntity toEntity(Loan loan) {
        LoanEntity entity = new LoanEntity();
        entity.setId(loan.id());
        entity.setCustomerId(loan.customerId());
        entity.setAmount(loan.amount());
        entity.setInterestRate(loan.interestRate());
        entity.setStartDate(loan.startDate());
        entity.setEndDate(loan.endDate());
        entity.setStatus(loan.status().name());
        return entity;
    }

    private Loan toDomain(LoanEntity entity) {
        return new Loan(
                entity.getId(),
                entity.getCustomerId(),
                entity.getAmount(),
                entity.getInterestRate(),
                entity.getStartDate(),
                entity.getEndDate(),
                Loan.LoanStatus.valueOf(entity.getStatus())
        );
    }

    @Entity
    @Table(name = "loans")
    public static class LoanEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;

        private String customerId;

        private BigDecimal amount;

        private BigDecimal interestRate;

        private LocalDate startDate;

        private LocalDate endDate;

        private String status;

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public BigDecimal getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public void setStartDate(LocalDate startDate) {
            this.startDate = startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public void setEndDate(LocalDate endDate) {
            this.endDate = endDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }

    public interface LoanJpaRepository extends JpaRepository<LoanEntity, UUID> {
        
        @Query("SELECT l FROM LoanEntity l WHERE l.customerId = :customerId")
        Optional<LoanEntity> findByCustomerId(@Param("customerId") String customerId);

        @Query("SELECT l FROM LoanEntity l WHERE l.status = :status")
        List<LoanEntity> findByStatus(@Param("status") String status);

        @Query("SELECT l FROM LoanEntity l WHERE l.amount BETWEEN :minAmount AND :maxAmount")
        List<LoanEntity> findByAmountBetween(
                @Param("minAmount") BigDecimal minAmount,
                @Param("maxAmount") BigDecimal maxAmount
        );
    }
}