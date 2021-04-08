package com.casadocodigo.basic.livraria.categoria;


import com.sun.istack.NotNull;

public class NovaCategoriaRequest {

    @NotNull
    private String nome;
    @NotNull
    private String descricao;

    public NovaCategoriaRequest( String nome, String descricao ) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria converter(CategoriaRepository categoriaRepository){
        Categoria categoria = categoriaRepository.findByNome(nome);
        return new Categoria( nome, descricao );
    }
}
