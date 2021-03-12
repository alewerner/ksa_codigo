package com.casadocodigo.basic.livraria.autor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(value = "/autores")
    @Transactional
    public String criar(@RequestBody NovoAutorRequest request) {

        Autor autor = request.toModel();
        entityManager.persist(autor);

        return  autor.toString();
    }
}
