package com.casadocodigo.basic.livraria.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {
    // TODO: 18/03/2021 comentar do import errado 
    @NotBlank
    private String nome;
    
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 400)
    private String descricao;

    public NovoAutorRequest(@NotBlank String nome, @NotBlank @Email String email, String descricao) {
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
