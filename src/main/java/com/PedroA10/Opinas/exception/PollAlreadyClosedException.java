package com.PedroA10.Opinas.exception;

public class PollAlreadyClosedException extends RuntimeException {
    public PollAlreadyClosedException(String message) {
        super(message);
    }
}
