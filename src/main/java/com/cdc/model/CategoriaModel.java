package com.cdc.model;


import jakarta.persistence.*;

@Entity
public class CategoriaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "categoria_id")
        private Long id;



        @Column(name = "nome")
        private String nome;

        public CategoriaModel() {
        }

        public CategoriaModel(String nome) {

            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }
}
