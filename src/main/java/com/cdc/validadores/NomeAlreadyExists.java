package com.cdc.validadores;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NomeAlreadyExistsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NomeAlreadyExists {
    String message() default "Categoria já cadastrada!!!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};






}
