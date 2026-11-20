// TODO(reto): archivo stubbeado; implementa los cuerpos.
// src/main/java/application/service/LoanValidationService.java
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import application.dto.CreateLoanRequest;
import application.exception.ValidationError;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoanValidationService {

    private static final int MAX_TERM_MONTHS = 360;
    private static final BigDecimal MIN_AMOUNT = new BigDecimal("1000");
    private static final BigDecimal MAX_AMOUNT = new BigDecimal("1000000");

    public void validate(CreateLoanRequest request) {
      throw new UnsupportedOperationException("TODO(reto): validate");
    }

    public static class ValidationException extends RuntimeException {
        private final List<ValidationError.FieldError> errors;

        public ValidationException(String message, List<ValidationError.FieldError> errors) {
            super(message);
            this.errors = errors;
        }

        public List<ValidationError.FieldError> getErrors() {
            return errors;
        }
    }
}