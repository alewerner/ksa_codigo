package com.casadocodigo.basic.livraria.livro;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class CadastraLivroService implements ICadastraLivroService {

    private LivroRepository livroRepository;

    @PersistenceContext
    private EntityManager manager;

    //ou com Autowired?
    public  CadastraLivroService (LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    //devolvendo a entidade, seria bom ter um dto
    public Livro cadastraLiveo(NovoLivroRequest request){
        Livro novoLivro = request.toModel(manager);
    return livroRepository.save(novoLivro);
    }

}

