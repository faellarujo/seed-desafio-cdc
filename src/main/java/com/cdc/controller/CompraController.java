package com.cdc.controller;

import com.cdc.exception.EstadoExistsException;
import com.cdc.exception.ValorIncorretoException;
import com.cdc.model.Compra;
import com.cdc.model.Estado;
import com.cdc.requests.CompraRequest;
import com.cdc.service.PedidoService;
import com.cdc.service.VerificaPaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CompraController {

    @Autowired
    VerificaPaisService verificaPaisService;

    @Autowired
    PedidoService pedidoService;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/compra")
    @Transactional
    public ResponseEntity<Compra> compra(@RequestBody @Valid CompraRequest compraRequest) {
        verificaSeOPaisPossuiEstadosCadastrados(compraRequest);
        ComparaValorDoPedidoComOvalorTotalDosItens(compraRequest);
        final Compra compra = compraRequest.toModel();
        entityManager.persist(compra);
        return ResponseEntity.status(HttpStatus.OK).body(compra);
    }

    private void verificaSeOPaisPossuiEstadosCadastrados(CompraRequest compraRequest) {
        List<Estado> listaEstados = new ArrayList<>(verificaPaisService.carregarEstadosDoPais(compraRequest.getPais()));
        if (listaEstados.size() > 0 && compraRequest.getEstado() == null) {
            throw new EstadoExistsException("Estado não pode ser vazio");
        }
    }

    private void ComparaValorDoPedidoComOvalorTotalDosItens(CompraRequest compraRequest) {
        if (compraRequest.getPedidoRequest().getTotal().compareTo(pedidoService.valorTotalDosItensDoCarrinho(compraRequest.getPedidoRequest().getItens())) != 0) {
            throw new ValorIncorretoException("O valor total da compra não confere com o valor total dos itens do pedido");
        }
    }
}