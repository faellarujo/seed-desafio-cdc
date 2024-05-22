package com.cdc.service;

import com.cdc.exception.CarrinhoSemItens;
import com.cdc.model.CarrinhoModel;
import com.cdc.model.ItenDoCarrinhoModel;
import com.cdc.model.Livro;
import com.cdc.requests.CarrinhoRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class CarrinhoService {


    @PersistenceContext
    EntityManager entityManager;

    public CarrinhoService() {
    }

    public void CarrinhoVazio(CarrinhoRequest carrinhoRequest) {
        carrinhoRequest.getItens().forEach(itenDoCarrinhoModel -> {
            if(itenDoCarrinhoModel.getQuantidade() == 0){
                throw new CarrinhoSemItens("Carrinho esta vazio");
            }
        });
    }

    public BigDecimal valorTotalDosItensDoCarrinho(CarrinhoModel carrinhoModel) {
        BigDecimal totalDoCarrinho = BigDecimal.ZERO;

        for (ItenDoCarrinhoModel itenDoCarrinhoModel : carrinhoModel.getItens()) {
            Livro livro = entityManager.find(Livro.class, itenDoCarrinhoModel.getIdLivro());
            BigDecimal valorDoLivro = new BigDecimal(livro.getPrecoDoLivro().toString());
            totalDoCarrinho = totalDoCarrinho.add(valorDoLivro.multiply(BigDecimal.valueOf(itenDoCarrinhoModel.getQuantidade())));
        }

        return totalDoCarrinho;
    }}
