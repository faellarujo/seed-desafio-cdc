package com.cdc.repository.controller;

import com.cdc.model.Estado;
import com.cdc.model.Pais;
import com.cdc.repository.EstadoRepository;
import com.cdc.requests.EstadoRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadoController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    public Pais pais;

    @PostMapping("/estado")
    @Transactional
    public ResponseEntity<Estado> cadastrarEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        pais = entityManager.find(Pais.class, estadoRequest.getPaisId());
        Estado estado = new Estado(estadoRequest.getNome(), pais.getId());
        estado.setPais(pais);
        entityManager.persist(estado);
        return ResponseEntity.status(HttpStatus.OK).body(estado);
    }


    @GetMapping("/estados")
    public ResponseEntity<List<Estado>> listarEstados(){
        return ResponseEntity.status(HttpStatus.OK).body(estadoRepository.findAll());
    }


}
