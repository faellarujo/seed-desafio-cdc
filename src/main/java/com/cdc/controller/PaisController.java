package com.cdc.controller;


import com.cdc.model.PaisModel;
import com.cdc.repository.PaisRepository;
import com.cdc.requests.PaisRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaisController {

    @Autowired
    public PaisRepository paisRepository;

    @PostMapping("/pais")
    @Transactional
    public ResponseEntity<PaisModel> cadastrarPais(@RequestBody @Valid PaisRequest paisRequest ){

        PaisModel pais = new PaisModel(paisRequest.getNome());
        pais = paisRequest.toModel();
        paisRepository.save(pais);
        return ResponseEntity.ok().body(pais);
    }
}
