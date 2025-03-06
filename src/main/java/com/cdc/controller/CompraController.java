package com.cdc.controller;

import com.cdc.exception.EstadoExistsException;
import com.cdc.exception.ValorIncorretoException;
import com.cdc.model.Compra;
import com.cdc.model.CupomDesconto;
import com.cdc.model.Estado;
import com.cdc.requests.CompraRequest;
import com.cdc.service.CupomService;
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

    @Autowired
    CupomService cupomService;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/compra")
    @Transactional
    public ResponseEntity<Compra> compra(@RequestBody @Valid CompraRequest compraRequest) {
        verificaSeOPaisPossuiEstadosCadastrados(compraRequest);
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
        cupomService.invalidaCupomUtilizado(compraRequest.getCodigoCupom());
        return ResponseEntity.status(HttpStatus.OK).body(compra);
    }

    private Long verrificaCupom(CompraRequest compraRequest) {
        if (compraRequest.getCodigoCupom() != null && compraRequest.getCodigoCupom().length() > 1) {
            final List<CupomDesconto> cupomDescontos = cupomService.verificaExistenciaDoCupom(compraRequest.getCodigoCupom());
            cupomService.verificaStatusCupom(cupomDescontos);
            cupomService.verificaDataValidadeCupom(cupomService.verificaExistenciaDoCupom(compraRequest.getCodigoCupom()));
            final CupomDesconto cupomDesconto = cupomDescontos.get(0);
            final Long id = cupomDesconto.getId();
            return id;
        }
        return null;
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