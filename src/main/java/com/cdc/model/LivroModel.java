package com.cdc.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String resumo;

    private String sumario;

    private BigDecimal precoDoLivro;

    private Integer numeroDePaginas;

    private String isbn;

    private LocalDate dataDePublicacao;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Um Livro tem uma categoria
    @JoinColumn(name = "categoria_id")
    @JsonIgnore
    private CategoriaModel categoria;
    @ManyToMany(fetch = FetchType.LAZY) // Um Autor tem um livro
    @JoinTable(name = "autores_livros",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id"))
    private List<AutorModel> autor;

    public LivroModel() {
    }

    public LivroModel(String titulo, String resumo, String sumario, BigDecimal precoDoLivro, Integer numeroDePaginas, String isbn, LocalDate dataDePublicacao, CategoriaModel categoria, AutorModel autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.precoDoLivro = precoDoLivro;
        this.numeroDePaginas = numeroDePaginas;
        this.isbn = isbn;
        this.dataDePublicacao = dataDePublicacao;
        this.categoria = categoria;
        this.autor = List.of(autor);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPrecoDoLivro() {
        return precoDoLivro;
    }

    public void setPrecoDoLivro(BigDecimal precoDoLivro) {
        this.precoDoLivro = precoDoLivro;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }

    public AutorModel getAutor() {
        return autor.get(0);
    }

    public void setAutor(AutorModel autor) {
        this.autor = List.of(autor);
    }
}
