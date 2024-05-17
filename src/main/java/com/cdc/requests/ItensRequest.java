package com.cdc.requests;

import com.cdc.model.LivroModel;
import com.cdc.validadores.ExistId;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ItensRequest {

    @NotNull
    @ExistId(domainClass = LivroModel.class, fieldName = "id")
    private Long idLivro;
    @NotNull
    @Min(1)
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
