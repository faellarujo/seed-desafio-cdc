package com.cdc.controller;


import com.cdc.dto.AutorRequest;
import com.cdc.dto.LivroRequest;
import com.cdc.model.AutorModel;
import com.cdc.model.LivroModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {


    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/livros")
    @Transactional
    public ResponseEntity<LivroModel> cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest ){
        LivroModel livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.status(HttpStatus.OK).body(livroRequest.toModel(entityManager));
    }
}
