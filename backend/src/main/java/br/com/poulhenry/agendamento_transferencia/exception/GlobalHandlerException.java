package br.com.poulhenry.agendamento_transferencia.exception;

import br.com.poulhenry.agendamento_transferencia.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(FeeNotApplicableException.class)
    public ResponseEntity<ErrorResponse> handleFeeNotApplicableException(FeeNotApplicableException ex) {
        return response(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedTypeException(MethodArgumentNotValidException ex) {
        FieldError error = ex.getBindingResult().getFieldError();
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                ex.getClass().getSimpleName(),
                error.getDefaultMessage()
        );

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }

    private ResponseEntity<ErrorResponse> response(HttpStatus status, Exception ex) {
        var error = new ErrorResponse(status.value(), ex.getClass().getSimpleName(), ex.getMessage());

        return ResponseEntity.status(status).body(error);
    }
}
