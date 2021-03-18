package com.casadocodigo.basic.livraria.autor;


import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {
private Long id;
private String nome;

    public AutorDto( Autor autor ) {
        this.nome = autor.getNome();
    }

    public static List<AutorDto> converter( List<Autor> autores ) {
        return autores.stream().map(AutorDto:: new).collect(Collectors.toList());
    }
}
