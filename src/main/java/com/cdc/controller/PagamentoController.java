package com.cdc.controller;

import com.cdc.exception.EstadoExistsException;
import com.cdc.model.Estado;
import com.cdc.model.Pais;
import com.cdc.requests.PagamentoRequest;
import com.cdc.service.VerificaPaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PagamentoController {


    @Autowired
    VerificaPaisService verificaPaisService;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/pagamento")
    @Transactional
    public String pagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {

        verificaSeOPaisPossuiEstadosCadastrados(pagamentoRequest);
        return pagamentoRequest.toString();

    }

    private void verificaSeOPaisPossuiEstadosCadastrados(PagamentoRequest pagamentoRequest) {
        List<Estado> listaEstados = new ArrayList<>(verificaPaisService.carregarEstadosDoPais(pagamentoRequest.getPais()));
        if (listaEstados.size() > 0 && pagamentoRequest.getEstado() == null) {
            throw new EstadoExistsException("Estado não pode ser vazio");
        }
    }


}
