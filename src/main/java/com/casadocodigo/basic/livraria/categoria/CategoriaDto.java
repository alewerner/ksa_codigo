package com.casadocodigo.basic.livraria.categoria;

public class CategoriaDto {

    private String nome;
    private String descricao;

    public CategoriaDto( Categoria categoria ) {
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }
}
