package com.casadocodigo.basic.livraria.categoria;

import java.util.List;
import java.util.stream.Collectors;


public class CategoriaDto {

    private Long id;
    private String nome;
    private String descricao;

    public CategoriaDto( Categoria categoria ) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public static List<CategoriaDto> converter( List<Categoria> categorias ) {
        return categorias.stream().map( CategoriaDto::new ).collect( Collectors.toList() );
    }
}
