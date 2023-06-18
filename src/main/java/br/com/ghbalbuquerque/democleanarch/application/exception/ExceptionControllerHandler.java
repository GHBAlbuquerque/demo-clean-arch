package br.com.ghbalbuquerque.democleanarch.application.exception;

import br.com.ghbalbuquerque.democleanarch.application.exception.model.AlreadyRegisteredException;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.ErrorDetails;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.NotFoundException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.util.Date;

@RestControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AlreadyRegisteredException.class})
    public ResponseEntity<ErrorDetails> resourceException(AlreadyRegisteredException ex, WebRequest request) {

        final var message = new ErrorDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400",
                "The request could not be completed due to a conflict.",
                ex.getCode(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                new Date());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ErrorDetails> resourceException(NotFoundException ex, WebRequest request) {

        final var message = new ErrorDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404",
                "The requested resource was not found.",
                ex.getCode(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date());

        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleUncaughtException(ValidationException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var root = ExceptionUtils.getRootCause(ex);

        final var message = new ErrorDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404",
                "The requested resource was not found.",
                ex.getClass().toString(),
                root.getCause().toString(),
                status.value(),
                new Date());

        return handleExceptionInternal(ex, message, null, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaughtException(Exception ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        final var message = new ErrorDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500",
                "The requested resource was not found.",
                ex.getClass().toString(),
                ex.getMessage(),
                status.value(),
                new Date());

        ex.printStackTrace();

        return handleExceptionInternal(ex, message, null, status, request);
    }
}
