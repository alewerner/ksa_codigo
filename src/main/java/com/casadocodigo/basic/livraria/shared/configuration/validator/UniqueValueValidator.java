package com.casadocodigo.basic.livraria.shared.configuration.validator;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(UniqueValue params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = entityManager.createQuery("select 1 from "+klass.getName()+ " where " + domainAttribute+ "=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.isTrue(list.size() <=1, "Foi encontrado mais de um " +klass+ " com o mesmo nome");

        return list.isEmpty();
    }
}
