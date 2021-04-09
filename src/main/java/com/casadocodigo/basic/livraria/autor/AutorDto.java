package com.casadocodigo.basic.livraria.autor;


import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {

    private Long id;
    private String nome;
    private LocalDate dataDeCriacao;

    public AutorDto( Autor autor ) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataDeCriacao = autor.getdataDeCriacao();
    }


    public static List<AutorDto> converter( List<Autor> autores ) {
        return autores.stream().map( AutorDto::new ).collect( Collectors.toList() );
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }
}
