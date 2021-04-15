package com.casadocodigo.basic.livraria.livro;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    @PostMapping( value = "/api/livro" )
    public Livro cadastrarLivro( @RequestBody @Valid NovoLivroRequest request ) {
        return null;
    }

    @GetMapping( value = "/api/livro/listarTodos" )
    public List<LivroDto> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return LivroDto.converter( livros );
    }
}
