package com.cdc.repository;

import com.cdc.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaisRepository extends JpaRepository<Pais, Long> {

    public List<Pais> findByNome(String nome);
    public Optional<Pais> findById(Long id);
}
