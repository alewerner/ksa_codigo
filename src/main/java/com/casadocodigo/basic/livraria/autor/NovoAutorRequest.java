package com.casadocodigo.basic.livraria.autor;


import com.sun.istack.NotNull;

public class NovoAutorRequest {


    @NotNull
    private String nome;
    @NotNull
    private String email;
    @NotNull
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
}
