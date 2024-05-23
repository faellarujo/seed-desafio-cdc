package com.cdc.controller;

import com.cdc.exception.EstadoExistsException;
import com.cdc.exception.PaisExistException;
import com.cdc.model.Pagamento;
import com.cdc.model.Pais;
import com.cdc.requests.PagamentoRequest;
import com.cdc.service.VerificaPaisService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public String pagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {

        List<Pais> listaPais = new ArrayList<>();
        listaPais = verificaPaisService.verificaSePaisEstaNaBase(pagamentoRequest.getPais());

        if (pagamentoRequest.getEstado().isEmpty()) {
            throw new EstadoExistsException("Estado não pode ser vazio");
        }
        //final Pagamento pagamento = pagamentoRequest.toModel();
       // return ResponseEntity.ok().body(pagamento);

        return "";
    }


}
