package com.cdc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record CategoriaDTO(@NotBlank String nome) {

}
