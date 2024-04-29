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
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/livros/{id}")
    public ResponseEntity<LivroModel> listaDetalhesLivro(@PathVariable Long id) {

        final LivroModel livroModel = entityManager.find(LivroModel.class, id);
        if(livroModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(livroModel);
    }

}
