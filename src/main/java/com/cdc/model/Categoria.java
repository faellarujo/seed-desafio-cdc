package com.cdc.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "categoria_id")
        private Long id;

        @Column(name = "nome")
        private String nome;
        //@JsonBackReference
        //@JsonManagedReference
        @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
        @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
        private List<Livro> livros;

        public void setNome(String nome) {
                this.nome = nome;
        }

        public List<Livro> getLivros() {
                return livros;
        }

        public void setLivros(List<Livro> livros) {
                this.livros = livros;
        }

        public Categoria() {
        }

        public Categoria(String nome) {
            this.nome = nome;
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }
}
