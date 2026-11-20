package application.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateLoanRequest(
    @NotNull(message = "Customer ID cannot be null")
    @Size(min = 1, message = "Customer ID cannot be empty")
    String customerId,

    @NotNull(message = "Amount cannot be null")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,

    @NotNull(message = "Interest rate cannot be null")
    @Positive(message = "Interest rate must be positive")
    BigDecimal interestRate,

    @NotNull(message = "Start date cannot be null")
    LocalDate startDate,

    @NotNull(message = "End date cannot be null")
    LocalDate endDate
) {
    public CreateLoanRequest {
        if (startDate != null && endDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }
}