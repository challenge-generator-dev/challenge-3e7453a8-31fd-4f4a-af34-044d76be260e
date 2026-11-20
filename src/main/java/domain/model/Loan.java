// TODO(reto): archivo stubbeado; implementa los cuerpos.
package domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

// Entidad de dominio que representa una solicitud de préstamo.
// No conoce persistencia ni transporte: solo reglas del negocio.
public record Loan(
    UUID id,
    String customerId,
    BigDecimal amount,
    BigDecimal interestRate,
    LocalDate startDate,
    LocalDate endDate,
    LoanStatus status
) {

    public enum LoanStatus {
        PENDING, APPROVED, REJECTED, ACTIVE, PAID
    }

    public Loan {
        if (id == null) {
            throw new IllegalArgumentException("Loan ID cannot be null");
        }
        if (customerId == null || customerId.isBlank()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (interestRate == null || interestRate.signum() < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
    }

    public BigDecimal calculateTotalPayment() {
      throw new UnsupportedOperationException("TODO(reto): calculateTotalPayment");
    }

    private BigDecimal interestForTerm() {
      throw new UnsupportedOperationException("TODO(reto): interestForTerm");
    }

    private long termInMonths() {
        return ChronoUnit.MONTHS.between(startDate, endDate);
    }
}