package com.cdc.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PaisModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pais_id")
    private Long id;
    private String nome;

    @JsonBackReference
    //@JsonManagedReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToMany(mappedBy = "pais", fetch = FetchType.LAZY)
    private List<EstadoModel> estados;

    public PaisModel() {
    }

    public PaisModel(Long id, String nome, List<EstadoModel> estado) {
        this.id = id;
        this.nome = nome;
        this.estados = estado;
    }

    public PaisModel(String nome) {
        this.nome = nome;
    }

    public PaisModel(Long paisId) {

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<EstadoModel> getEstado() {
        return estados;
    }

    public void setEstado(List<EstadoModel> estado) {
        this.estados = estado;
    }

    public PaisModel(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
