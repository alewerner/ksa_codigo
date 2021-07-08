package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class CadastraLivroServiceTest {

    @InjectMocks
    private CadastraLivroService cadastraLivroService;

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private AutorRepository autorRepository;

    @Test
    public void criaLivroComSucesso() {

        NovoLivroRequest novoLivroRequest1 = new NovoLivroRequest(
                "resumo",
                "sumario",
                BigDecimal.valueOf(3.33),
                888,
                "isbn",
                LocalDate.now(),
                1L,
                1L,
                "titulo"

        );

        Autor autor = Mockito.mock(Autor.class);
        Categoria categoria = Mockito.mock(Categoria.class);

        Mockito.when(autorRepository.findById(1L)).thenReturn(Optional.of(autor));
        Mockito.when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        cadastraLivroService.cadastraLivro(novoLivroRequest1);

        Mockito.verify(livroRepository,
                Mockito.times(1))
                .save(ArgumentMatchers.any(Livro.class));
    }
}