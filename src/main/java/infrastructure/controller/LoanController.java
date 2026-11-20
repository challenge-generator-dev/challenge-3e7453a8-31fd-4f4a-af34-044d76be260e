// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.controller;

import application.dto.CreateLoanRequest;
import application.service.LoanService;
import domain.model.Loan;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody @Valid CreateLoanRequest request) {
      throw new UnsupportedOperationException("TODO(reto): createLoan");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoan(@PathVariable String id) {
      throw new UnsupportedOperationException("TODO(reto): GetMapping");
    }
}