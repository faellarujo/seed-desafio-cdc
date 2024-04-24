package com.cdc.dto;

import com.cdc.model.LivroModel;

import java.util.ArrayList;
import java.util.List;

public class LivrosDto {
    private Long id;
    private String titulo;

    public LivrosDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public LivrosDto() {
    }

    public static List<LivrosDto> toDto(List selectLFromLivroModelL) {
        List<LivroModel> livroModels = new ArrayList<>();   //1
        livroModels.addAll(selectLFromLivroModelL);
        List<LivrosDto> livrosDto = new ArrayList<>();

        livroModels.stream().forEach(livro -> { //1
            LivrosDto livroDto = new LivrosDto();
            livroDto.id = livro.getId();
            livroDto.titulo = livro.getTitulo();
            livrosDto.add(livroDto);
        });
        return livrosDto;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
