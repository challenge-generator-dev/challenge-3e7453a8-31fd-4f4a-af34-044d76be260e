// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import application.dto.CreateLoanRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanTestDataBuilder {

    private static final String DEFAULT_CUSTOMER_ID = "CUST-001";
    private static final BigDecimal DEFAULT_AMOUNT = new BigDecimal("10000.00");
    private static final BigDecimal DEFAULT_INTEREST_RATE = new BigDecimal("0.05");
    private static final LocalDate DEFAULT_START_DATE = LocalDate.now();
    private static final LocalDate DEFAULT_END_DATE = LocalDate.now().plusMonths(12);

    public CreateLoanRequest buildValidRequest() {
      throw new UnsupportedOperationException("TODO(reto): buildValidRequest");
    }

    public CreateLoanRequest buildInvalidRequest() {
      throw new UnsupportedOperationException("TODO(reto): buildInvalidRequest");
    }

    public CreateLoanRequest buildInvalidRequest(
            String customerId,
            BigDecimal amount,
            BigDecimal interestRate,
            LocalDate startDate,
            LocalDate endDate) {
              throw new UnsupportedOperationException("TODO(reto): buildInvalidRequest");
            }
}