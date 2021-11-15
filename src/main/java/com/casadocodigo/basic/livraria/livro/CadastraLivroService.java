package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastraLivroService implements ICadastraLivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void cadastraLivro( NovoLivroRequest request ) {
        Optional<Autor> autor = autorRepository.findById( request.getIdAutor() );
        if ( autor.isEmpty() ) {
            throw new EntityNotFoundException();
        }

        Optional<Categoria> categoria = categoriaRepository.findById( request.getIdCategoria() );
        if ( categoria.isEmpty() ) {
            throw new EntityNotFoundException();
        }

        Livro livro = new Livro( request.getTitulo(), request.getResumo(), request.getSumario(), request.getPreco(),
            request.getNumeroPaginas(), request.getIsbn(), request.getDataPublicacao(), categoria.get(), autor.get() );

        livroRepository.save( livro );
    }

}

