package com.cdc.service;

import com.cdc.exception.CupomDataException;
import com.cdc.exception.CupomExisteException;
import com.cdc.exception.CupomInativoException;
import com.cdc.model.CupomDesconto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CupomService {

    @PersistenceContext
    EntityManager entityManager;

    public List<CupomDesconto> verificaExistenciaDoCupom(String codigoCupom) {

        List<CupomDesconto> listCupom = new ArrayList<>();
        listCupom = entityManager.createQuery("select c from CupomDesconto c where c.codigo = :codeCupom", CupomDesconto.class)
                .setParameter("codeCupom", codigoCupom)
                .getResultList();

        if (listCupom.isEmpty()) {
            throw new CupomExisteException("Cupom não encontrado");
        }
        return listCupom;
    }

    public void verificaDataValidadeCupom(List<CupomDesconto> cupomDesconto) {
        Optional<CupomDesconto> cupom = cupomDesconto.stream().findFirst();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // ajuste o padrão para corresponder ao formato da sua data
        LocalDate validade = LocalDate.parse(cupom.get().getValidade(), formatter);
        if (validade.isBefore(LocalDate.now())) {
            throw new CupomDataException("Cupom expirado");
        }
    }


    public List<CupomDesconto> verificaStatusCupom(List<CupomDesconto> cupomDesconto) {
        Optional<CupomDesconto> cupom = cupomDesconto.stream().findFirst();
        if (cupom.get().getEstatusCupom().name().equals("INATIVO")) {
            throw new CupomInativoException("Cupom inativo");
        }
        return cupomDesconto;
    }

    public void invalidaCupomUtilizado(String codigoCupom) {
        Query query = entityManager.createQuery("update CupomDesconto c set c.estatusCupom = 'INATIVO' where c.codigo = :codeCupom");
        query.setParameter("codeCupom", codigoCupom);
        query.executeUpdate();
    }
}





