package com.cdc.requests;

import com.cdc.model.ItenDoCarrinhoModel;
import com.cdc.validadores.UniqueValue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItensRequest {

    @NotNull
    @UniqueValue(domainClass = ItenDoCarrinhoModel.class, fieldName = "idLivro")
    private Long idLivro;

    private int quantidade;



    public ItensRequest() {
    }

    public ItensRequest(@NotNull Long idLivro, int quantidade) {
        this.idLivro = idLivro;
        this.quantidade = quantidade;
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

    @Override
    public String toString() {
        return "ItensRequest{" +
                "idLivro=" + idLivro +
                ", quantidade=" + quantidade +
                '}';
    }
}
