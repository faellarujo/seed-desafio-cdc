package com.cdc.repository;

import com.cdc.model.AutorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<AutorModel, Long>, NomeRepository<AutorModel> {

    AutorModel findByEmail(String email);
}
