package com.PedroA10.Opinas.exception;

import lombok.Data;

@Data
public class ErrorResponse {
    private int status;
    private String message;
}
