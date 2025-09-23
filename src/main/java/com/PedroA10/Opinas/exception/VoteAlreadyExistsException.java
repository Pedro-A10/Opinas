package com.PedroA10.Opinas.exception;

public class VoteAlreadyExistsException extends RuntimeException {
    public VoteAlreadyExistsException(String message) {
        super(message);
    }
}
