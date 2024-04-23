package com.cdc.controller;


import com.cdc.dto.AutorRequest;
import com.cdc.model.AutorModel;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {

    /**
     * Simula a criação de um autor
     * @param autorRecord
     * @return
     *
     * 100% de coesao, os metodos estão fazendo uso de todos os atributis
     *
     */
    @Autowired
    EntityManager entityManager;
    @PostMapping("/autores")
    @Transactional
    public ResponseEntity<AutorModel> saveProduct(@RequestBody @Valid AutorRequest autorRequest){ //1
        entityManager.persist(autorRequest.toModel());
        return ResponseEntity.status(HttpStatus.OK).body(autorRequest.toModel()); //2
    }
}
