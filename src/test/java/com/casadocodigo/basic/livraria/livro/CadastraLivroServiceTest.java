package com.casadocodigo.basic.livraria.livro;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.casadocodigo.basic.livraria.utils.RequestLivroMock;
import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith( MockitoExtension.class )
@RunWith( MockitoJUnitRunner.class )
public class CadastraLivroServiceTest {

    @InjectMocks
    private CadastraLivroService cadastraLivroService;

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private AutorRepository autorRepository;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Test
    public void testaCriarLivroComSucesso() {
        Autor autor = mock( Autor.class );
        Categoria categoria = mock( Categoria.class );
        when( autorRepository.findById( 1L ) ).thenReturn( Optional.of( autor ) );

        when( categoriaRepository.findById( 1L ) ).thenReturn( Optional.of( categoria ) );

        cadastraLivroService.cadastraLivro( RequestLivroMock.getRequestNovoLivro() );
        verify( livroRepository, times( 1 ) ).save( ArgumentMatchers.any( Livro.class ) );
    }

    @Test
    public void assertCategoriaNotFound() {
        Autor autor = mock( Autor.class );
        when( autorRepository.findById( 1L ) ).thenReturn( Optional.of( autor ) );
        when( categoriaRepository.findById( 1L ) ).thenReturn( Optional.empty() );
        assertThrows( EntityNotFoundException.class,
            () -> cadastraLivroService.cadastraLivro( RequestLivroMock.getRequestNovoLivro() ) );
    }

    @Test
    public void assertAutorNotFound() {
        when( autorRepository.findById( 1L ) ).thenReturn( Optional.empty() );
        assertThrows( EntityNotFoundException.class,
            () -> cadastraLivroService.cadastraLivro( RequestLivroMock.getRequestNovoLivro() ) );
    }
}