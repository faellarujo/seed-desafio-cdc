package com.cdc.controller;


import com.cdc.requests.CategoriaRequest;
import com.cdc.model.Categoria;
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
   public ResponseEntity<Categoria> saveProduct(@RequestBody @Valid CategoriaRequest categoriaRequest){
       Categoria model = categoriaRequest.toModel();
       entityManager.persist(model);
       return ResponseEntity.status(HttpStatus.OK).body(model);
    }
}
