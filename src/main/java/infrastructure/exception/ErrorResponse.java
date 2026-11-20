package infrastructure.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path,
    List<ValidationDetail> details
) {
    public record ValidationDetail(
        String field,
        String message
    ) {}
}