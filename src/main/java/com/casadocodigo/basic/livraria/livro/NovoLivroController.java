package com.casadocodigo.basic.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NovoLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping(value = "api/livros")
    public String postLivro(@RequestBody NovoLivroRequest novoLivroRequest) {
        return "";
    }
}
