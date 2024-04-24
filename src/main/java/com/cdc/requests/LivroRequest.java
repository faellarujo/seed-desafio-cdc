package com.cdc.requests;

import com.cdc.model.AutorModel;
import com.cdc.model.CategoriaModel;
import com.cdc.model.LivroModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.constraints.*;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroRequest {

    @PersistenceContext
    EntityManager entityManager;

    @NotBlank
    private String titulo;

    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotNull
    @Min(20)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal preco;

    @NotNull
    private int numeroPaginas;

    @NotBlank
    private String isbn;

    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dataPublicacao;

    @NotNull
    private Long idCategoria;

    @NotNull
    private Long idAutor;


    public LivroRequest(
            @NotBlank String titulo,
            @NotBlank String resumo,
            @NotBlank String sumario,
            @NotNull BigDecimal preco,
            @NotNull int numeroPaginas,
            @NotBlank String isbn,
            @NotNull  @JsonFormat(pattern = "dd/MM/yyyy")
                      @JsonDeserialize(using = LocalDateDeserializer.class)
                      @JsonSerialize(using = LocalDateSerializer.class) LocalDate dataPublicacao,
            @NotNull Long idCategoria,
            @NotNull Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public LivroModel toModel(EntityManager entityManager) {
        AutorModel autorModel = entityManager.find(AutorModel.class, idAutor);
        CategoriaModel categoriaModel = entityManager.find(CategoriaModel.class, idCategoria);
        Assert.state(autorModel != null, "Você está querendo cadastrar um livro para um autor que não existe no banco " + idAutor);
        Assert.state(categoriaModel != null, "Você está querendo cadastrar um livro para uma categoria que não existe no banco " + idCategoria);
        return new LivroModel(this.titulo, this.resumo, this.sumario, this.preco, this.numeroPaginas, this.isbn, this.dataPublicacao, categoriaModel, autorModel);
    }
}
