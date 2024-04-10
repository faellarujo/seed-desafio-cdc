package com.cdc.controller;


import com.cdc.dtos.AutorRecord;
import com.cdc.model.AutorModel;
import com.cdc.repository.AutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutorController {

    /**
     * Simula a criação de um autor
     * @param autorRecord
     * @return
     *
     * 100% de coesao, os metodos estão fazendo uso de todos os atributis
     *
     */

    @Autowired
    private AutorRepository autorRepository;
    @PostMapping("/autores")
    public ResponseEntity<AutorModel> saveProduct(@RequestBody @Valid AutorRecord autorRecord){
        AutorModel autorModel = new AutorModel();
        BeanUtils.copyProperties(autorRecord, autorModel);
        return ResponseEntity.status(HttpStatus.OK).body(autorRepository.save(autorModel));
    }
}
