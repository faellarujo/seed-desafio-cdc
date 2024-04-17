package com.cdc.service;

import com.cdc.dto.CategoriaDTO;
import com.cdc.exception.CategoriaExisteException;
import com.cdc.model.CategoriaModel;
import com.cdc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    public CategoriaRepository categoriaRepository;

//    public void categoriaDuplicada(CategoriaModel model) {
//        if (categoriaRepository.findByNome(model.getNome()) != null){ //
//            throw new CategoriaExisteException("Categoria já cadastrada");
//        }
//    }
}
