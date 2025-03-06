package com.cdc.exception;

public class DocumentoObrigatorio extends RuntimeException{
    public DocumentoObrigatorio(String message) {
        super(message);
    }
}
