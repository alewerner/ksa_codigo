package com.casadocodigo.basic.livraria.categoria;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Optional;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class NovaCategoriaRequest {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String descricao;

    public NovaCategoriaRequest( String nome, String descricao ) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Categoria converter(CategoriaRepository categoriaRepository){
        Optional<Categoria> categoria = categoriaRepository.findByNomeIgnoreCase(nome);
        return new Categoria( nome, descricao );
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
