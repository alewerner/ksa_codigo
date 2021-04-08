package com.casadocodigo.basic.livraria.livro;

import com.casadocodigo.basic.livraria.autor.Autor;
import com.casadocodigo.basic.livraria.categoria.Categoria;
import com.casadocodigo.basic.livraria.shared.configuration.validator.UniqueValue;

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
    // TODO: 04/04/2021 criar validação que a data é maior que a data atual - não pode ter datas no passado
    @NotBlank
    @Future
    private LocalDate dataPublicacao;
    @NotNull

    private Categoria categoria;
    @NotNull
    private Autor autor;

    @Deprecated
    public NovoLivroRequest() {
    }

    public NovoLivroRequest(@NotBlank String resumo, @NotBlank String sumario, @NotBlank @Min(20) BigDecimal preco, @NotBlank @Min(100) Integer numPaginas,
                            @NotBlank String isbn, LocalDate dataPublicacao, @NotBlank Categoria categoria, @NotBlank Autor autor) {
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numPaginas = numPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
