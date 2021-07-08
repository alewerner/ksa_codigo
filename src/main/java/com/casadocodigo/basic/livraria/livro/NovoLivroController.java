package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.externalservices.BookSearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class NovoLivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CadastraLivroService service;

    @Autowired
    private BookSearchClient client;

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "api/livros")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public void postLivro(@RequestBody NovoLivroRequest novoLivroRequest) {
        service.cadastraLivro(novoLivroRequest);
    }

    @GetMapping(value = "api/getAllLivros")
    public List<Livro> getAllLivros() {
        return service.buscaLivros();
    }

    @GetMapping(value = "api/livro/{idLivro}")
    public Livro getLivroById(@RequestParam Long idLivro) {
        Optional<Livro> optionalLivro = service.getLivroById(idLivro);

        if (optionalLivro.isPresent()) {
            return optionalLivro.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "api/livro/isbnExiste/{isbn}")
    public String isbnExiste(@RequestParam String isbn) {
        return client.getBooksById(isbn);
    }
}
