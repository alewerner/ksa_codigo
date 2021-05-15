package com.casadocodigo.basic.livraria.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Entity
public class Categoria {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Size( max = 400 )
    private String descricao;

    private boolean ativo;

    public Categoria( String nome, String descricao ) {
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = true;
    }

    @Deprecated
    public Categoria() {
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

    @Override
    public String toString() {
        return "Categoria{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", descricao='" + descricao + '\'' +
            ", ativo=" + ativo +
            '}';
    }
}
