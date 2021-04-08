package com.casadocodigo.basic.livraria.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Categoria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    public Categoria( String nome, String descricao ) {
        this.descricao = descricao;
        this.nome = nome;
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
            ", nomeDaCategoria='" + nome + '\'' +
            ", descricaoDaCategoria='" + descricao + '\'' +
            '}';
    }
}
