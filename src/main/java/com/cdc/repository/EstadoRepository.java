package com.cdc.repository;

import com.cdc.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    public Estado findByNome(String nome);


    public Estado findByNomeAndPaisId(String nome, Long paisId);


}
