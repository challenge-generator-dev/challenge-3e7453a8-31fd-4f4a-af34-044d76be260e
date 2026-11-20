// TODO(reto): archivo stubbeado; implementa los cuerpos.
package application.service;

import application.dto.CreateLoanRequest;
import domain.model.Loan;
import domain.port.LoanRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final LoanValidationService validationService;

    public LoanService(LoanRepository loanRepository, LoanValidationService validationService) {
        this.loanRepository = loanRepository;
        this.validationService = validationService;
    }

    public Loan createLoan(CreateLoanRequest request) {
      throw new UnsupportedOperationException("TODO(reto): createLoan");
    }

    public Loan getLoan(String id) {
      throw new UnsupportedOperationException("TODO(reto): getLoan");
    }

    public static class LoanNotFoundException extends RuntimeException {
        public LoanNotFoundException(String message) {
            super(message);
        }
    }
}