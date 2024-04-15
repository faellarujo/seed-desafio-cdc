package com.cdc.repository;

import com.cdc.model.AutorModel;
import com.cdc.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>, NomeRepository<CategoriaModel> {


}
