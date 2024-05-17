package com.cdc.controller;


import com.cdc.model.CarrinhoModel;
import com.cdc.requests.CarrinhoRequest;
import com.cdc.service.CarrinhoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CarrinhoController {

    @Autowired
    public CarrinhoService carrinhoService;

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/carrinho")
    @Transactional
    public ResponseEntity<CarrinhoModel> carrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest){
        final CarrinhoModel model = carrinhoRequest.toModel();
        final BigDecimal ValorDosItens = carrinhoService.valorTotalDosItensDoCarrinho(model);
        entityManager.persist(model);


        return ResponseEntity.status(HttpStatus.OK).body(model);
    }
}
