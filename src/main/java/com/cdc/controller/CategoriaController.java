package com.cdc.controller;


import com.cdc.exception.CategoriaExisteException;
import com.cdc.model.CategoriaModel;
import com.cdc.repository.CategoriaRepository;
import com.cdc.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired
    public CategoriaRepository categoriaRepository; //1

    @Autowired
    public CategoriaService categoriaService; //1

    @PostMapping("/categorias")
   public ResponseEntity<CategoriaModel> saveProduct(@RequestBody @Valid CategoriaModel model){
        try {
            categoriaService.categoriaDuplicada(model); //1
        } catch (CategoriaExisteException e) { //1
            throw new CategoriaExisteException(e.getMessage()); //1
        }
        CategoriaModel categoriaModel = new CategoriaModel(model.getNome()); //1
        return ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoriaModel));
    }
}
