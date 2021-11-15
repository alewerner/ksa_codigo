package com.casadocodigo.basic.livraria.livro;

import java.math.BigDecimal;

public class DetalheLivroSiteReponse {

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getAutor() {
        return autor;
    }

    private final String titulo;
    private final String isbn;
    private final Integer numeroPaginas;
    private final BigDecimal preco;
    private final String resumo;
    private final String sumario;
    private final String autor;

    public DetalheLivroSiteReponse(Livro livroBuscado) {
        this.titulo = livroBuscado.getTitulo();
        this.isbn = livroBuscado.getIsbn();
        this.numeroPaginas = livroBuscado.getNumeroPaginas();
        this.preco = livroBuscado.getPreco();
        this.resumo = livroBuscado.getResumo();
        this.sumario = livroBuscado.getSumario();
        this.autor = livroBuscado.getAutor().getNome();
    }

}
