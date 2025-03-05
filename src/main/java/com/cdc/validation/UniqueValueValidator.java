package com.cdc.validation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;



public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<?> domainClass;
    private String fieldName;

    @Override
    public void initialize(UniqueValue constraintAnnotation) {
        domainClass = constraintAnnotation.domainClass();
        fieldName = constraintAnnotation.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        String query = String.format("select count(1) from %s where %s = :value", domainClass.getName(), fieldName);
        Long count = entityManager.createQuery(query, Long.class)
                .setParameter("value", value)
                .getSingleResult();

        return count == 0;
    }
}
