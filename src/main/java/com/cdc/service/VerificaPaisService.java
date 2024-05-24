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

    public List<Estado> carregarEstadosDoPais(long id_pais) {
        return entityManager.createQuery("select e from Estado e where e.pais.id = :id_pais", Estado.class)
                .setParameter("id_pais", id_pais)
                .getResultList();
    }

}
