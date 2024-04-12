package com.cdc.service;


import com.cdc.exception.EmailExistsException;
import com.cdc.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {


    @Autowired
    public AutorRepository autorRepository;
    public void EmailDuplicado(String email) {
        if (autorRepository.findByEmail(email) != null) { //1
            throw new EmailExistsException("O e-mail já existe na base de dados.");
        }
    }
}
