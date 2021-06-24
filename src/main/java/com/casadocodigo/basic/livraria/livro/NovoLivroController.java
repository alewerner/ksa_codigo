package com.casadocodigo.basic.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class NovoLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CadastraLivroService service;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "api/livros")
    @Transactional
    public String postLivro(@RequestBody NovoLivroRequest novoLivroRequest) {
        return service.cadastraLiveo(novoLivroRequest).toString();
    }
}
