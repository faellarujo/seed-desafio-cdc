package com.cdc.controller;

import com.cdc.exception.EstadoExistsException;
import com.cdc.model.Estado;
import com.cdc.requests.PagamentoParte01Request;
import com.cdc.service.PaisService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagamentoParte01Controller {

    @Autowired
    PaisService paisService;

    @PostMapping("/pagamentoParteUm")
    @Transactional
    public ResponseEntity<String> compra(@RequestBody @Valid PagamentoParte01Request compraRequest) {

        final List<Estado> estados = paisService.carregarEstadosDoPaisCasoExistam(compraRequest.getPais());
        if (!estados.isEmpty() || !compraRequest.getEstado().isEmpty()) {
            if (estados.stream().noneMatch(estado -> estado.getNome().equals(compraRequest.getEstado()))) {
                throw new EstadoExistsException("O Estado informado não pertence a este Pais");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(compraRequest.toString());
    }
}
