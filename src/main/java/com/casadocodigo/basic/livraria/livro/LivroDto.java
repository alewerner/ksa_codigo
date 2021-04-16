package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDto {

    private String titulo;
    private String isbn;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int numeroDePaginas;
    private Date dataDePublicacao;
    private Autor autorDoLivro;
    private Categoria categoriaDoLivro;

    public LivroDto( Livro livro ) {
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.dataDePublicacao = livro.getDataDePublicacao();
        this.autorDoLivro = livro.getAutorDoLivro();
        this.categoriaDoLivro = livro.getCategoriaDoLivro();
    }

    @Deprecated
    public LivroDto() {
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

    public Autor getAutorDoLivro() {
        return autorDoLivro;
    }

    public Categoria getCategoriaDoLivro() {
        return categoriaDoLivro;
    }

    public static List<LivroDto> converter( List<Livro> livros ) {
        return livros.stream().map( LivroDto::new ).collect( Collectors.toList() );
    }
}
