package com.cdc.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategoriaModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "categoria_id")
        private Long id;

        @Column(name = "nome")
        private String nome;
        @JsonManagedReference
        @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
        private List<LivroModel> livros;

        public void setNome(String nome) {
                this.nome = nome;
        }

        public List<LivroModel> getLivros() {
                return livros;
        }

        public void setLivros(List<LivroModel> livros) {
                this.livros = livros;
        }

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
