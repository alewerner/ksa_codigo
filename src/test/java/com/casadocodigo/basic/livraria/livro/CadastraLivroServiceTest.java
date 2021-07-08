package com.casadocodigo.basic.livraria.livro;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import com.casadocodigo.basic.livraria.TestMock;
import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    @Captor
    ArgumentCaptor<Autor> autorRepositoryrgumentCaptor;

    @Captor
    ArgumentCaptor<Categoria> categoriaRepositoryrgumentCaptor;

    @Test
    public void testaCriarLivroComSucesso() {
        Autor autor = mock( Autor.class );
        Categoria categoria = mock( Categoria.class );
        when( autorRepository.findById( 1L ) ).thenReturn( Optional.of( autor ) );

        when( categoriaRepository.findById( 1L ) ).thenReturn( Optional.of( categoria ) );

        cadastraLivroService.cadastraLivro( TestMock.getRequest() );
        verify( livroRepository, times( 1 ) ).save( ArgumentMatchers.any( Livro.class ) );
    }

    @Test
    public void testaAutorNaoEncontrado() {
        when( autorRepository.findById( anyLong() ) )
            .thenReturn( Optional.empty() );

        cadastraLivroService.cadastraLivro( TestMock.getRequest() );

        verify( autorRepository ).save( autorRepositoryrgumentCaptor.capture() );

        assertNull( autorRepositoryrgumentCaptor.getValue().getId() );
    }

    @Test
    public void testeCategoriaNaoEncontrada() {

        when( categoriaRepository.findById( anyLong() ) )
            .thenReturn( Optional.empty() );

        cadastraLivroService.cadastraLivro( TestMock.getRequest() );

        verify( categoriaRepository ).save( categoriaRepositoryrgumentCaptor.capture() );

        assertNull( categoriaRepositoryrgumentCaptor.getValue().getId() );

    }
}