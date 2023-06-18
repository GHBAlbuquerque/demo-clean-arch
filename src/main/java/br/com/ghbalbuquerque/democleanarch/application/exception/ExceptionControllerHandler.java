package br.com.ghbalbuquerque.democleanarch.application.exception;

import br.com.ghbalbuquerque.democleanarch.application.exception.custom.AlreadyRegisteredException;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.CreateEntityException;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.CustomException;
import br.com.ghbalbuquerque.democleanarch.application.exception.model.ExceptionDetails;
import br.com.ghbalbuquerque.democleanarch.application.exception.custom.EntityNotFoundException;
import br.com.ghbalbuquerque.democleanarch.application.notification.interfaces.NotificationContext;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private NotificationContext notificationContext;

    @ExceptionHandler(value = {CreateEntityException.class})
    public ResponseEntity<ExceptionDetails> resourceException(CustomException ex, WebRequest request) {

        final var message = new ExceptionDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400",
                "The server could not process the request due to a client error.",
                ex.getCode(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                notificationContext.getNotifications());

        cleanNotifications();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {AlreadyRegisteredException.class})
    public ResponseEntity<ExceptionDetails> resourceException(AlreadyRegisteredException ex, WebRequest request) {

        final var message = new ExceptionDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400",
                "The request could not be completed due to a conflict.",
                ex.getCode(),
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                null);

        cleanNotifications();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<ExceptionDetails> resourceException(EntityNotFoundException ex, WebRequest request) {

        final var message = new ExceptionDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/404",
                "The requested resource was not found.",
                ex.getCode(),
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                null);

        cleanNotifications();
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> handleUncaughtException(ValidationException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var root = ExceptionUtils.getRootCause(ex);

        final var message = new ExceptionDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/400",
                "Bad Request.",
                ex.getClass().toString(),
                root.getCause().toString(),
                status.value(),
                new Date(),
                null);

        cleanNotifications();
        return handleExceptionInternal(ex, message, null, status, request);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUncaughtException(Exception ex, WebRequest request) {
        var status = HttpStatus.INTERNAL_SERVER_ERROR;

        final var message = new ExceptionDetails(
                "https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500",
                "Internal server error. Please contact the admin.",
                ex.getClass().toString(),
                ex.getMessage(),
                status.value(),
                new Date(),
                null);

        ex.printStackTrace();

        cleanNotifications();
        return handleExceptionInternal(ex, message, null, status, request);
    }

    private void cleanNotifications(){
        System.out.println("List of errors in NotificationContext will be cleaned up for next request.");
       notificationContext.cleanNotifications();
    }
}
