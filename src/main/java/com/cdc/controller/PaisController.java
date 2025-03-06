package com.cdc.controller;


import com.cdc.model.Pais;
import com.cdc.repository.PaisRepository;
import com.cdc.requests.PaisRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaisController {

    @Autowired
    public PaisRepository paisRepository;


    @PostMapping("/pais")
    @Transactional
    public ResponseEntity<Pais> cadastrarPais(@RequestBody @Valid PaisRequest paisRequest ){

        Pais pais = new Pais(paisRequest.getNome());
        pais = paisRequest.toModel();
        paisRepository.save(pais);
        return ResponseEntity.ok().body(pais);
    }

    @GetMapping(value = "/paises")
    public ResponseEntity<List<Pais>> listarPaises(){
        List<Pais> paises = paisRepository.findAll();
        return ResponseEntity.ok().body(paises);
    }
}
