package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.shared.configuration.ExistsId;
import com.casadocodigo.basic.livraria.shared.configuration.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

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

    @Deprecated
    public NovoLivroRequest() {
    }

    public NovoLivroRequest(@NotBlank String resumo, @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numPaginas,
                            @NotBlank String isbn, LocalDate dataPublicacao, @NotBlank Long idCategoria, @NotBlank Long idAutor) {
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
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
}
