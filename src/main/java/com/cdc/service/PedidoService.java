package com.cdc.service;

import com.cdc.model.Livro;
import com.cdc.requests.ItensRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    @PersistenceContext
    EntityManager entityManager;

    public BigDecimal valorTotalDosItensDoCarrinho(List<ItensRequest> itens) {
        BigDecimal totalDoCarrinho = BigDecimal.ZERO;
        for (ItensRequest itensRequest : itens) {
            Livro livro = entityManager.find(Livro.class, itensRequest.getIdLivro());
            totalDoCarrinho = totalDoCarrinho.add(livro.getPrecoDoLivro().multiply(BigDecimal.valueOf(itensRequest.getQuantidade())));
        }
        return totalDoCarrinho;
    }
}