package com.casadocodigo.basic.livraria.autor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

public class NovoAutorRequest {


    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;


    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String descricao;

    public NovoAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
