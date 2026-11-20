// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {
              throw new UnsupportedOperationException("TODO(reto): ExceptionHandler");
            }

    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLoanNotFoundException(
            LoanNotFoundException ex,
            HttpServletRequest request) {
              throw new UnsupportedOperationException("TODO(reto): ExceptionHandler");
            }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(
            Exception ex,
            HttpServletRequest request) {
              throw new UnsupportedOperationException("TODO(reto): ExceptionHandler");
            }

    public static class LoanNotFoundException extends RuntimeException {
        public LoanNotFoundException(String message) {
            super(message);
        }
    }
}