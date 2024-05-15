package com.cdc.service;

import com.cdc.exception.CarrinhoSemItens;
import com.cdc.model.CarrinhoModel;
import com.cdc.requests.CarrinhoRequest;
import org.springframework.stereotype.Service;


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




}
