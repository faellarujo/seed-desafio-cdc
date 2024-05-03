package com.cdc.controller;

import com.cdc.requests.PagamentoRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    @PostMapping("/pagamento")
    public String pagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {
        return new PagamentoRequest(pagamentoRequest.getEmail(), pagamentoRequest.getNome(), pagamentoRequest.getSobrenome(), pagamentoRequest.getDocumento(), pagamentoRequest.getEndereco(), pagamentoRequest.getComplemento(), pagamentoRequest.getCidade(), pagamentoRequest.getPais(), pagamentoRequest.getEstado(), pagamentoRequest.getTelefone(), pagamentoRequest.getCep()).toString();

    }
}
