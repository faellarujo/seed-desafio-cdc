package com.cdc.exception;

public class PaisExistException extends RuntimeException{
    public PaisExistException(String message) {
        super(message);
    }
}
