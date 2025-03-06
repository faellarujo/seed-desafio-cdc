package com.cdc.controller;

import com.cdc.requests.PagamentoParte01Request;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoParte01Controller {

    @PostMapping("/pagamentoParteUm")
    @Transactional
    public ResponseEntity<String> compra(@RequestBody @Valid PagamentoParte01Request compraRequest) {
        /*verificaSeOPaisPossuiEstadosCadastrados(compraRequest);
        ComparaValorDoPedidoComOvalorTotalDosItens(compraRequest);
        final Long cupomID = verrificaCupom(compraRequest);
        if (cupomID != null) {
            final Compra compra = compraRequest.toModelComCupom(cupomID);
            compra.setCupomDesconto(entityManager.find(CupomDesconto.class, cupomID));
            entityManager.persist(compra);
            cupomService.invalidaCupomUtilizado(compraRequest.getCodigoCupom());
            return ResponseEntity.status(HttpStatus.OK).body(compra);
        }
        final Compra compra = compraRequest.toModel();
        entityManager.persist(compra);
        cupomService.invalidaCupomUtilizado(compraRequest.getCodigoCupom());*/
        return ResponseEntity.status(HttpStatus.OK).body(compraRequest.toString());
}
}
