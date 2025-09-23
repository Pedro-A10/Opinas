package com.PedroA10.Opinas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handUserAlreadyExists(UserAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }
    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<String> handEmailNotFound(EmailNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    @ExceptionHandler(PollNotFoundException.class)
    public ResponseEntity<String> handPollNotFound(PollNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<String> handWrongPassword(WrongPasswordException ex) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(ex.getMessage());
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handUserNotFound(UserNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    //Para futuramente adicionar prazo para votação em enquetes.
    @ExceptionHandler(PollAlreadyClosedException.class)
    public ResponseEntity<String> handPollAlreadyClosed(PollAlreadyClosedException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
    @ExceptionHandler(OptionAlreadyExistsException.class)
    public ResponseEntity<String> handOptionAlreadyExists(OptionAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }
    @ExceptionHandler(VoteAlreadyExistsException.class)
    public ResponseEntity<String> handVoteAlreadyExists(VoteAlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }
}