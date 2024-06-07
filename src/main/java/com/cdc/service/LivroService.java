package com.cdc.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

@Service
public class LivroService {

    @PersistenceContext
    EntityManager entityManager;

    public String NomeDoLivro(Long idDoLivro) {
        Query query = entityManager.createQuery("select l.nome from Livro l where l.id = :idLivro");
        query.setParameter("idLivro", idDoLivro);
        String nomeDoLivro = (String) query.getSingleResult();
        return nomeDoLivro;
    }
}
