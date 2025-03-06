package com.cdc.controller;


import com.cdc.requests.AutorRequest;
import com.cdc.model.Autor;
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
    public ResponseEntity<Autor> saveProduct(@RequestBody @Valid AutorRequest autorRequest) {
        Autor model = autorRequest.toModel();
        entityManager.persist(model);
        return ResponseEntity.status(HttpStatus.OK).body(model);

    }
}
