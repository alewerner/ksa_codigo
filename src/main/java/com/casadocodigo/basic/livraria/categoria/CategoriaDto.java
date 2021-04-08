package com.casadocodigo.basic.livraria.categoria;

public class CategoriaDto {

    private Long id;
    private String nome;
    private String descricao;

    public CategoriaDto( Categoria categoria ) {
        this.nome = categoria.getNome();
    }
}
