package com.cdc.repository;

import org.springframework.data.jpa.repository.Query;

public interface NomeRepository<T> {    public T findByNome(String nome); //1


}
