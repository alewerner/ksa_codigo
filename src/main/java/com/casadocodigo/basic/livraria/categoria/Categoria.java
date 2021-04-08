package com.casadocodigo.basic.livraria.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    public Categoria( String nome, String descricao ) {
        this.nome = nome;
        this.descricao = descricao;
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
