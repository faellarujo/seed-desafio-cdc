package com.cdc.controller;


import com.cdc.model.CategoriaModel;
import com.cdc.repository.CategoriaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired
    public CategoriaRepository categoriaRepository; //1


    @PersistenceContext
    private EntityManager manager;
   @PostMapping("/categorias")
   public ResponseEntity<CategoriaModel> saveProduct(@RequestBody @Valid CategoriaModel model){
           return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(model));
    }


}
