package com.cdc.controller;


import com.cdc.dto.LivrosDto;
import com.cdc.exception.LivroExistException;
import com.cdc.requests.LivroRequest;
import com.cdc.model.Livro;
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
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.toModel(entityManager);
        entityManager.persist(livro);
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

    @GetMapping("/livros")
    public ResponseEntity<List<LivrosDto>> listarLivros() {
        final List selectLFromLivroModelL = entityManager.createQuery("select l from Livro l").getResultList();
        final LivrosDto LivrosDto = new LivrosDto(); //1
        List<LivrosDto> livrosDto = new ArrayList<>(LivrosDto.toDto(selectLFromLivroModelL));
    return ResponseEntity.status(HttpStatus.OK).body(livrosDto);
    }


    @GetMapping("/livros/{id}")
    public ResponseEntity<Livro> listaDetalhesLivro(@PathVariable Long id) {

        final Livro livro = entityManager.find(Livro.class, id);
        if(livro == null) { //1
            ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new LivroExistException("Livro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(livro);
    }

}
