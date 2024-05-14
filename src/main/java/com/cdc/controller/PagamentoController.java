package com.cdc.controller;

import com.cdc.exception.EstadoExistsException;
import com.cdc.model.EstadoModel;
import com.cdc.model.PaisModel;
import com.cdc.requests.PagamentoRequest;
import com.cdc.service.VerificaPaisService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagamentoController {


    @Autowired
    VerificaPaisService verificaPaisService;

    @PostMapping("/pagamento")
    public ResponseEntity<PaisModel> pagamento(@RequestBody @Valid PagamentoRequest pagamentoRequest) {

        verificaPaisService.verificaSePaisEstaNaBase(pagamentoRequest.getPais().getNome());
        final List<PaisModel> paisModels = verificaPaisService.verificaSePaisEstaNaBase(pagamentoRequest.getPais().getNome());

        if (pagamentoRequest.getEstado().getNome().isEmpty()) {
            throw new EstadoExistsException("Estado não pode ser vazio");
        }

        return ResponseEntity.ok().body(paisModels.get(0));
    }

}
