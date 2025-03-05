package com.cdc.repository.controller;


import com.cdc.model.CupomDesconto;
import com.cdc.requests.CupomDescontoRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CupomController {

    @PersistenceContext
    EntityManager entityManager;

    @PostMapping("/cupom")
    @Transactional
    public String cadastrarCupom(@RequestBody  @Valid CupomDescontoRequest cupomDescontoRequest){
        final CupomDesconto cupom = cupomDescontoRequest.toModel();
        entityManager.persist(cupom);
        return cupomDescontoRequest.toString();
    }


}
