package com.casadocodigo.basic.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class NovoLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping(value = "api/livros")
    @Transactional
    public String postLivro(@RequestBody NovoLivroRequest novoLivroRequest) {
        return "";
    }
}