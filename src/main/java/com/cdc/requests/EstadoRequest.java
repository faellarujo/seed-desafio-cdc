package com.cdc.requests;

import com.cdc.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EstadoRequest {


    @NotBlank
    private String nome;

    @NotNull(message = "É obrigatório informar o país ao qual o estado pertence.")
    private Long paisId;

    public EstadoRequest(@NotBlank String nome, @NotNull Long paisId) {
        this.nome = nome;
        this.paisId = paisId;
    }

    public EstadoRequest() {
    }

    public EstadoRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPaisId() {
        return paisId;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public Estado toModel() {
        return new Estado(this.nome, this.paisId);
    }


}

