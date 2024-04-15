package com.cdc.repository;

public interface NomeRepository<T> {
    public T findByNome(String nome); //1
}
