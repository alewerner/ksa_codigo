package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.autor.AutorRepository;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.categoria.CategoriaRepository;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;
import javax.persistence.Column;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

public class NovoLivroRequest {




    @NotBlank
    @Column( unique = true )
    private String titulo;

    @NotBlank
    @Size( min = 20, max = 20 )
    @ApiModelProperty( example = "ISBN 978-0-7334-2609" )
    @Column( unique = true )
    private String isbn;

    @NotBlank
    @Size( max = 500 )
    private String resumo;

    @NotBlank
    @Size( max = 1000 )
    private String sumario;

    @NotNull
    @Min( 20 )
    private  BigDecimal preco;

    @NotNull
    @Min( 100 )
    private int numeroDePaginas;

    @NotNull
    private Date dataDePublicacao;

    @NotNull
    private Long idAutor;

    @NotNull
    private Long idCategoria;

    public NovoLivroRequest(
        @NotBlank String titulo,
        @NotBlank @Size( min = 20, max = 20 ) String isbn,
        @NotBlank @Size( max = 500 ) String resumo,
        @NotBlank @Size( max = 1000 ) String sumario,
        @NotNull @Min( 20 ) BigDecimal preco,
        @NotNull @Min( 100 ) int numeroDePaginas, @NotNull Date dataDePublicacao,
        @NotNull Long idAutor,
        @NotNull Long idCategoria ) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.dataDePublicacao = dataDePublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    @Deprecated
    public NovoLivroRequest() {
    }

    public Livro toModel(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        Optional<Autor> autor = autorRepository.findById( idAutor );
        Optional<Categoria> categoria = categoriaRepository.findById( idCategoria );

        if ( autor.isEmpty() ) {
            throw new EntityNotFoundException();
        }

        if ( categoria.isEmpty() ) {
            throw new EntityNotFoundException();
        }

        return new Livro( this.titulo, this.isbn, this.resumo, this.sumario, this.preco, this.numeroDePaginas,
            this.dataDePublicacao, autor.get(), categoria.get() );
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public Date getDataDePublicacao() {
        return dataDePublicacao;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }
}
