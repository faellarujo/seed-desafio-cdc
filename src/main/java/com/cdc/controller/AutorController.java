package com.cdc.controller;


import com.cdc.dto.AutorDTO;
import com.cdc.exception.EmailExistsException;
import com.cdc.model.AutorModel;
import com.cdc.repository.AutorRepository;
import com.cdc.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class    AutorController {

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

    @Autowired
    private AutorService autorService;//1
    @PostMapping("/autores")
    public ResponseEntity<AutorModel> saveProduct(@RequestBody @Valid AutorDTO autorDTO){ //1
        try {
            autorService.EmailDuplicado(autorDTO.email());//1
        } catch (EmailExistsException e) { //1
            throw new EmailExistsException(e.getMessage()); //1
        }
        AutorModel autorModel = new AutorModel();//1
        BeanUtils.copyProperties(autorDTO, autorModel);
        return ResponseEntity.status(HttpStatus.OK).body(autorRepository.save(autorModel));
    }
}
