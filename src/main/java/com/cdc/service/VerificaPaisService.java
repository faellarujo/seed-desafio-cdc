package com.cdc.service;

import com.cdc.model.Estado;
import com.cdc.model.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerificaPaisService {


    @PersistenceContext
    EntityManager entityManager;

    public VerificaPaisService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Pais> verificaSePaisEstaNaBase(String nome) {
               final List Paises = entityManager.createQuery("select p from Pais p where p.nome = :nome")
                .setParameter("nome", nome)
                .getResultList();
        return Paises;
    }

    public List<Estado> carregarEstadosDoPais(String nome) {
        final List Estados = entityManager.createQuery("select p from Estado p where p.nome = :nome")
                .setParameter("nome", nome)
                .getResultList();
        return Estados;
    }

}
