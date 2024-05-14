package com.cdc.service;

import com.cdc.model.EstadoModel;
import com.cdc.model.PaisModel;
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

    public List<PaisModel> verificaSePaisEstaNaBase(String nome) {
               final List Paises = entityManager.createQuery("select p from PaisModel p where p.nome = :nome")
                .setParameter("nome", nome)
                .getResultList();
        return Paises;
    }

    public List<EstadoModel> carregarEstadosDoPais(String nome) {
        final List Estados = entityManager.createQuery("select p from EstadoModel p where p.nome = :nome")
                .setParameter("nome", nome)
                .getResultList();
        return Estados;
    }

}
