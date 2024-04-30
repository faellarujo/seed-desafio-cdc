package com.cdc.exception;

public class LivroExistException extends RuntimeException{
    public LivroExistException(String message) {
        super(message);
    }
}
