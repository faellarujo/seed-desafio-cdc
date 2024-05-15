package com.cdc.controller;


import com.cdc.requests.CarrinhoRequest;
import com.cdc.service.CarrinhoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarrinhoController {

    @Autowired
    public CarrinhoService carrinhoService;



    @PostMapping("/carrinho")
    public String carrinho(@RequestBody @Valid CarrinhoRequest carrinhoRequest){
        carrinhoService.CarrinhoVazio(carrinhoRequest);
        return carrinhoRequest.toString();
    }
}
