package application.exception;

import java.util.List;

public record ValidationError(
    String message,
    List<FieldError> errors
) {
    public record FieldError(
        String field,
        String error
    ) {}
}