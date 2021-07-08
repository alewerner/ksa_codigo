package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CadastraLivroService implements ICadastraLivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    //devolvendo a entidade, seria bom ter um dto
    public void cadastraLivro(NovoLivroRequest request) {

        Optional<Autor> autor = autorRepository.findById(request.getIdAutor());

        if (autor.isEmpty()) {
            throw new EntityNotFoundException();
        }

        Optional<Categoria> categoria = categoriaRepository.findById(request.getIdCategoria());

        if (categoria.isEmpty()) {
            throw new EntityNotFoundException();
        }

        Livro novoLivro = new Livro(request.getTitulo(),
                request.getResumo(), request.getSumario(),
                request.getPreco(), request.getNumPaginas(),
                request.getIsbn(), request.getDataPublicacao(),
                categoria.get(), autor.get());

        livroRepository.save(novoLivro);
    }

    @Override
    public List<Livro> buscaLivros() {
        return livroRepository.findAll();
    }

    @Override
    public Optional<Livro> getLivroById(Long idLivro) {
        return livroRepository.findById(idLivro);
    }
}

