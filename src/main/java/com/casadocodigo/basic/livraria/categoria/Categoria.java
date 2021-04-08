package com.casadocodigo.basic.livraria.categoria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Categoria {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDaCategoria;
    private String descricaoDaCategoria;

    public Categoria( String nomeDaCategoria, String descricaoDaCategoria ) {
        this.descricaoDaCategoria = descricaoDaCategoria;
        this.nomeDaCategoria = nomeDaCategoria;
    }

    public String getNomeDaCategoria() {
        return nomeDaCategoria;
    }

    public String getDescricaoDaCategoria() {
        return descricaoDaCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
            "id=" + id +
            ", nomeDaCategoria='" + nomeDaCategoria + '\'' +
            ", descricaoDaCategoria='" + descricaoDaCategoria + '\'' +
            '}';
    }
}
