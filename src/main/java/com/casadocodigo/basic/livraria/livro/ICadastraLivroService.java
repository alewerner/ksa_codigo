package com.casadocodigo.basic.livraria.livro;

import java.util.List;
import java.util.Optional;

public interface ICadastraLivroService {

    void cadastraLivro(NovoLivroRequest request);

    List<Livro> buscaLivros();

    Optional<Livro> getLivroById(Long idLivro);
}
