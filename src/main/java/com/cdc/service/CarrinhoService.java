package com.cdc.service;

import com.cdc.exception.CarrinhoSemItens;
import com.cdc.model.CarrinhoModel;
import com.cdc.model.LivroModel;
import com.cdc.requests.CarrinhoRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class CarrinhoService {

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
        final BigDecimal totalDoCarrinho = carrinhoModel.getTotal();
        carrinhoModel.getItens().forEach(itenDoCarrinhoModel -> {
            final BigDecimal valorDoLivro = new BigDecimal(0);
            final int quantidade = itenDoCarrinhoModel.getQuantidade();
            final BigDecimal total = valorDoLivro.multiply(new BigDecimal(quantidade));
            totalDoCarrinho.add(total);
        });
        return totalDoCarrinho;

    }}
