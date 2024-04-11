package com.cdc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record AutorDTO(@NotBlank String nome, @NotEmpty String email, @NotBlank String descricao) {
}
