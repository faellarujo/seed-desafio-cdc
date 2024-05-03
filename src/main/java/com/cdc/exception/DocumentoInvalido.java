package com.cdc.exception;

public class DocumentoInvalido extends RuntimeException{
    public DocumentoInvalido(String message) {
        super(message);
    }
}
