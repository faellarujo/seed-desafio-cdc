package com.cdc.controller;


import com.cdc.requests.CategoriaRequest;
import com.cdc.model.CategoriaModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @PersistenceContext
    EntityManager entityManager;
   @PostMapping("/categorias")
   @Transactional
   public ResponseEntity<CategoriaModel> saveProduct(@RequestBody @Valid CategoriaRequest categoriaRequest){
       entityManager.persist(categoriaRequest.toModel());
       return ResponseEntity.status(HttpStatus.OK).body(categoriaRequest.toModel());
    }
}
