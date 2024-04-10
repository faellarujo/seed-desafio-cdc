package com.cdc.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record AutorRecord(@NotBlank String nome, @NotBlank String email, @NotBlank String descricao, @NotBlank LocalDateTime instante) {

    public AutorRecord {
        nome = nome;
        email = email;
        descricao = descricao;
        instante = LocalDateTime.now();
    }

}
