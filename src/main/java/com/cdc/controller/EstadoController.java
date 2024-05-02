package com.cdc.controller;

import com.cdc.exception.PaisExistException;
import com.cdc.model.EstadoModel;
import com.cdc.model.PaisModel;
import com.cdc.repository.EstadoRepository;
import com.cdc.requests.EstadoRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstadoController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    public PaisModel paisModel;

    @PostMapping("/estados")
    @Transactional
    public ResponseEntity<EstadoModel> cadastrarEstado(@RequestBody @Valid EstadoRequest estadoRequest){
        paisModel = entityManager.find(PaisModel.class, estadoRequest.getPaisId());
        EstadoModel estadoModel = new EstadoModel(estadoRequest.getNome(), paisModel.getId());
        estadoModel.setPais(paisModel);
        entityManager.persist(estadoModel);
        return ResponseEntity.status(HttpStatus.OK).body(estadoModel);
    }


}
