package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Livro {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

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

    @NotBlank
    @Min( 20 )
    private double preco;

    @NotBlank
    @Min( 100 )
    private int numeroDePaginas;

    @NotBlank
    private Date dataDePublicacao;

    @NotBlank
    private Autor autorDoLivro;

    @NotBlank
    private Categoria categoriaDoLivro;

    public Livro(
        @NotBlank String titulo,
        @NotBlank @Size( min = 20, max = 20 ) String isbn,
        @NotBlank @Size( max = 500 ) String resumo,
        @NotBlank @Size( max = 1000 ) String sumario,
        @NotBlank @Min( 20 ) double preco,
        @NotBlank @Min( 100 ) int numeroDePaginas, @NotBlank Date dataDePublicacao,
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
