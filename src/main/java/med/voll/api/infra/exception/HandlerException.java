package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<HandlerException> error404Exception(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorValidation>> error400Exception(MethodArgumentNotValidException exception){
        List<FieldError> errors = exception.getFieldErrors();

        return ResponseEntity.badRequest()
                .body(
                errors.stream()
                        .map(ErrorValidation::new)
                        .toList());
    }

    public record ErrorValidation(String input, String message){
        public ErrorValidation(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
