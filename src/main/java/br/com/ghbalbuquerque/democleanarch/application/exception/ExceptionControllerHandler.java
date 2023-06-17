package br.com.ghbalbuquerque.democleanarch.application.exception;

import br.com.ghbalbuquerque.democleanarch.application.exception.model.AlreadyRegisteredException;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.ErrorDetails;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestControllerAdvice
public class ExceptionControllerHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AlreadyRegisteredException.class})
    public ResponseEntity<ErrorDetails> resourceException(AlreadyRegisteredException ex, WebRequest request) {

        final var message = new ErrorDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/409",
                "The request could not be completed due to a conflict.",
                ex.getCode(),
                ex.getMessage(),
                HttpStatus.CONFLICT.value(),
                new Date());

        return new ResponseEntity<>(message, HttpStatus.CONFLICT);
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
}
