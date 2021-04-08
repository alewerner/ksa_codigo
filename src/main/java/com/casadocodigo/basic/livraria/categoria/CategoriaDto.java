package com.casadocodigo.basic.livraria.categoria;

public class CategoriaDto {

    private Long id;
    private String nome;
    private String descricao;

    public CategoriaDto( Categoria categoria ) {
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
