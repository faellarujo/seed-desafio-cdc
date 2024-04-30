package com.cdc.repository;

import com.cdc.model.EstadoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<EstadoModel, Long> {

    public EstadoModel findByNome(String nome);


    public EstadoModel findByNomeAndPaisId(String nome, Long paisId);


}
