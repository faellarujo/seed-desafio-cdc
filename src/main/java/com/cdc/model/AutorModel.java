package com.cdc.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class AutorModel {

    @Id
    @Column(name = "autor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;

    @Column(name = "instante")
    private LocalDateTime instante = LocalDateTime.now();

    @ManyToMany(mappedBy = "autor")
    private List<LivroModel> livroModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInstante(LocalDateTime instante) {
        this.instante = instante;
    }

    public List<LivroModel> getLivroModel() {
        return livroModel;
    }

    public void setLivroModel(List<LivroModel> livroModel) {
        this.livroModel = livroModel;
    }

    public AutorModel() {
    }

    public AutorModel(String nome, String email, String descricao, LocalDateTime instante) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getInstante() {
        return instante;
    }



}

