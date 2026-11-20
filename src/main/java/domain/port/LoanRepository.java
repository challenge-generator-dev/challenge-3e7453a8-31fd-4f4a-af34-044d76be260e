package domain.port;

import domain.model.Loan;
import java.util.Optional;
import java.util.UUID;

public interface LoanRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(UUID id);
    void deleteById(UUID id);
}