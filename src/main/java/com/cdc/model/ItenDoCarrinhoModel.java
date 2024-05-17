package com.cdc.model;

import com.cdc.validadores.ExistId;
import com.cdc.validadores.UniqueValue;
import jakarta.persistence.*;


@Entity
public class ItenDoCarrinhoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idLivro;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "carrinho_id")
    private CarrinhoModel carrinhoModel;

    public ItenDoCarrinhoModel() {
    }

    public Long getId() {
        return id;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CarrinhoModel getCarrinhoModel() {
        return carrinhoModel;
    }

    public void setCarrinhoModel(CarrinhoModel carrinhoModel) {
        this.carrinhoModel = carrinhoModel;
    }

    public ItenDoCarrinhoModel(Long idLivro, int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
    }
}


