package com.cdc.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "email", nullable = false, length = 50)
    @Email(message = "Email inválido")
    private String email;

    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;

    @Column(name = "instante", nullable = false)
    private LocalDateTime instante;

}
