package com.cdc.validadores;

import com.cdc.exception.CategoriaExisteException;
import com.cdc.model.CategoriaModel;
import com.cdc.repository.CategoriaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class NomeAlreadyExistsValidator implements ConstraintValidator<NomeAlreadyExists, String> {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void initialize(NomeAlreadyExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        try {
            Optional<CategoriaModel> byNome = Optional.ofNullable(categoriaRepository.findByNome(nome));
            return byNome.isEmpty();
        } catch (NullPointerException e) {
            return true;
            //throw new CategoriaExisteException("Categoria já cadastrada!!!");
        }

    }
}

