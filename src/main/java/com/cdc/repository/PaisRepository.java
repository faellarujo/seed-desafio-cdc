package com.cdc.repository;

import com.cdc.model.PaisModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaisRepository extends JpaRepository<PaisModel, Long> {

    public List<PaisModel> findByNome(String nome);
    public Optional<PaisModel> findById(Long id);
}
