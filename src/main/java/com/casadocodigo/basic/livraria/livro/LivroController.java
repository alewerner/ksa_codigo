package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
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
    AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Transactional
    @PostMapping( value = "/api/livro" )
    public String cadastrarLivro( @RequestBody @Valid NovoLivroRequest request ) {
        Livro livro = request.toModel(autorRepository,categoriaRepository );
        livroRepository.save( livro );
        return livro.toString();
    }

    @GetMapping( value = "/api/livro/listarTodos" )
    public List<LivroDto> listarTodos() {
        List<Livro> livros = livroRepository.findAll();
        return LivroDto.converter( livros );
    }
}
