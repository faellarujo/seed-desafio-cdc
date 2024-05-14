package com.cdc.exception;

public class EstadoExistsException extends RuntimeException{
    public EstadoExistsException(String message) {
        super(message);
    }
}
