package com.cdc.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Entity
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email", nullable = false, length = 50)
    @Email(message = "Email inválido")
    private String email;

    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;

    @Column(name = "instante")
    private LocalDateTime instante = LocalDateTime.now();

//    public AutorModel(String nome, String email, String descricao, LocalDateTime instante) {
//        this.nome = nome;
//        this.email = email;
//        this.descricao = descricao;
//    }

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

