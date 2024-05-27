package com.cdc.service;

import com.cdc.exception.CarrinhoSemItens;
import com.cdc.model.Livro;
import com.cdc.requests.ItensRequest;
import com.cdc.requests.PedidoRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
public class CompraService {


    @PersistenceContext
    EntityManager entityManager;

    public CompraService() {
    }

    public void CarrinhoVazio(PedidoRequest pedidoRequest) {
        pedidoRequest.getItens().forEach(itenDoCarrinhoModel -> {
            if(itenDoCarrinhoModel.getQuantidade() == 0){
                throw new CarrinhoSemItens("Carrinho esta vazio");
            }
        });
    }

    public BigDecimal valorTotalDosItensDoCarrinho(PedidoRequest pedidoRequests) {
        BigDecimal totalDoCarrinho = BigDecimal.ZERO;
        List<ItensRequest> itens = pedidoRequests.getItens();
        for (ItensRequest itensRequest : itens) {
            Livro livro = entityManager.find(Livro.class, itensRequest.getIdLivro());
            totalDoCarrinho = totalDoCarrinho.add(livro.getPrecoDoLivro().multiply(BigDecimal.valueOf(itensRequest.getQuantidade())));
        }
        return totalDoCarrinho;
    }
}
