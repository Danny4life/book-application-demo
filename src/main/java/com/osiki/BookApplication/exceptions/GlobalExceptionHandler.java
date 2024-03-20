package com.osiki.BookApplication.exceptions;

import com.osiki.BookApplication.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(final EmailAlreadyExistsException e){
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.CONFLICT));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleUserNotFoundException(final UserNotFoundException e){
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.BAD_REQUEST));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleBookNotFoundException(final BookNotFoundException e){
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.NOT_FOUND));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseEntity<ErrorDetails> handlePasswordNotMatchException(final PasswordNotMatchException e){
        ErrorDetails errorResponse = new ErrorDetails();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setErrorDetails(String.valueOf(HttpStatus.BAD_REQUEST));
        errorResponse.setErrorMessage(e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);

    }
}
