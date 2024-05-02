package com.cdc.controller;


import com.cdc.requests.PagamentoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoController {

    @PostMapping("/pagamento")
    public String pagamento(@RequestBody PagamentoRequest pagamentoRequest) {
        return "Pagamento realizado com sucesso";
    }









}
