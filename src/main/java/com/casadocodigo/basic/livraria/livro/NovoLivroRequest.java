package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.shared.configuration.ExistsId;
import com.casadocodigo.basic.livraria.shared.configuration.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class NovoLivroRequest {

    @NotBlank
    @Max(500)
    private String resumo;
    @NotBlank
    private String sumario;
    @NotBlank
    private BigDecimal preco;
    @NotBlank
    private Integer numPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @NotBlank
    @UniqueValue(domainClass = Livro.class,fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    //@DateTimeFormat
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long idCategoria;

    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long idAutor;

    public String getTitulo() {
        return titulo;
    }

    @Deprecated
    public NovoLivroRequest() {
    }

    public NovoLivroRequest(@NotBlank String resumo, @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numPaginas,
                            @NotBlank String isbn, LocalDate dataPublicacao, @NotBlank Long idCategoria, @NotBlank Long idAutor, @NotBlank String titulo) {
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
        this.titulo = titulo;

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

    public Integer getNumPaginas() {
        return numPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public Livro toModel(EntityManager manager) {
        @NotNull Autor autor = manager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(Objects.nonNull(autor),"Você esta querendo cadastrar um livro para um autor que nao existe no banco "+idAutor);
        Assert.state(Objects.nonNull(categoria),"Você esta querendo cadastrar um livro para uma categoria que nao existe no banco "+idCategoria);

        return new Livro(titulo,
                resumo, sumario, preco, numPaginas, isbn,
                dataPublicacao, categoria, autor);
    }
}
