package com.casadocodigo.basic.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscaLivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Optional<DetalheLivroSiteReponse> getLivroERetornaReponse(Long id) {

        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new DetalheLivroSiteReponse(livro.get()));
    }

    public Optional<Livro> getLivroPorId(Long id) {

        Optional<Livro> livro = livroRepository.findById(id);

        if (livro.isEmpty()) {
            return Optional.empty();
        }

        return livro;
    }
}
