package com.cdc.repository;

import com.cdc.model.AutorModel;
import com.cdc.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

    @Query("SELECT c FROM CategoriaModel c WHERE c.nome = :nome")
    CategoriaModel findByNome(String nome);
}
