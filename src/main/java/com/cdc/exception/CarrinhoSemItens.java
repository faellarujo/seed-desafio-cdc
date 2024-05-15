package com.cdc.exception;

public class CarrinhoSemItens extends RuntimeException {
    public CarrinhoSemItens(String message) {
        super(message);
    }
}
