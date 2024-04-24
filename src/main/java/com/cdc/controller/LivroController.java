package com.cdc.controller;


import com.cdc.dto.LivrosDto;
import com.cdc.requests.LivroRequest;
import com.cdc.model.LivroModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LivroController {


    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/livros")
    @Transactional
    public ResponseEntity<LivroModel> cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        LivroModel livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.status(HttpStatus.OK).body(livroRequest.toModel(entityManager));
    }

    @GetMapping("/livros")
    public ResponseEntity<List<LivrosDto>> listarLivros() {
        final List selectLFromLivroModelL = entityManager.createQuery("select l from LivroModel l").getResultList();
        final LivrosDto LivrosDto = new LivrosDto(); //1
        List<LivrosDto> livrosDto = new ArrayList<>(LivrosDto.toDto(selectLFromLivroModelL));
    return ResponseEntity.status(HttpStatus.OK).body(livrosDto);
    }
}
