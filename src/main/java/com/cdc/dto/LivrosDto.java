package com.cdc.dto;

import com.cdc.model.Livro;

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
        List<Livro> livros = new ArrayList<>();   //1
        livros.addAll(selectLFromLivroModelL);
        List<LivrosDto> livrosDto = new ArrayList<>();

        livros.stream().forEach(livro -> { //1
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
