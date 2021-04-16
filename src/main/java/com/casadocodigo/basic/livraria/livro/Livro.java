package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.validation.constraints.NotBlank;

@Entity
public class Livro {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String isbn;

    @NotBlank
    private String resumo;

    @NotBlank
    private String sumario;

    @NotBlank
    private double preco;

    @NotBlank
    private int numeroDePaginas;

    @NotBlank
    private Date dataDePublicacao;

    @NotBlank
    @JoinTable(name = "AUTOR")
    private Autor autorDoLivro;

    @NotBlank
    @JoinTable(name = "CATEGORIA")
    private Categoria categoriaDoLivro;

    public Livro(
        @NotBlank String titulo, @NotBlank String isbn,
        @NotBlank String resumo, @NotBlank String sumario, @NotBlank double preco,
        @NotBlank int numeroDePaginas, @NotBlank Date dataDePublicacao,
        @NotBlank Autor autorDoLivro,
        @NotBlank Categoria categoriaDoLivro ) {

        this.titulo = titulo;
        this.isbn = isbn;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroDePaginas = numeroDePaginas;
        this.dataDePublicacao = dataDePublicacao;
        this.autorDoLivro = autorDoLivro;
        this.categoriaDoLivro = categoriaDoLivro;
    }

    @Deprecated
    public Livro() {
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

    public double getPreco() {
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

    @Override
    public String toString() {
        return "Livro{" +
            "id=" + id +
            ", titulo='" + titulo + '\'' +
            ", isbn='" + isbn + '\'' +
            ", resumo='" + resumo + '\'' +
            ", sumario='" + sumario + '\'' +
            ", preco=" + preco +
            ", numeroDePaginas=" + numeroDePaginas +
            ", dataDePublicacao=" + dataDePublicacao +
            ", autorDoLivro=" + autorDoLivro +
            ", categoriaDoLivro=" + categoriaDoLivro +
            '}';
    }
}
