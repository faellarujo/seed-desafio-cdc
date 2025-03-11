package com.cdc.service;

import com.cdc.model.Estado;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {


    @PersistenceContext
    EntityManager entityManager;

    public PaisService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Estado> carregarEstadosDoPaisCasoExistam(String pais) {
        return entityManager.createQuery("select e from Estado e where e.pais.nome = :pais", Estado.class)
                .setParameter("pais", pais)
                .getResultList();
    }

}
