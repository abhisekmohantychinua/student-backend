package dev.abhisek.studentbackend.handler;

import dev.abhisek.studentbackend.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandleException {
    /**
     * Handles all kind of exceptions which are not handled or recognized
     *
     * @param exception {@link Exception}
     * @return internal_server_error with and error message which is written by developer
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception) {
        exception.printStackTrace();
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Some unrecognised exception occurred...");
    }

    /**
     * Handles particularly {@link StudentNotFoundException}
     *
     * @param exception {@link StudentNotFoundException}
     * @return not_found along with the message mentioned in the class
     */
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> studentNotFoundExceptionHandler(StudentNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }
}
