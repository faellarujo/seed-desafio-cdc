package com.cdc.service;


import com.cdc.exception.CategoriaExisteException;
import com.cdc.exception.EmailExistsException;
import com.cdc.model.AutorModel;
import com.cdc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {


    @Autowired
    public AutorRepository autorRepository;
    public void EmailDuplicado(AutorModel autorRequest) {
        if (autorRepository.findByEmail(autorRequest.getEmail()) != null){ //1
            throw new EmailExistsException("Email já cadastrado");
        }

    }
}
