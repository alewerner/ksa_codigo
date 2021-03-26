package com.casadocodigo.basic.livraria.autor;


import java.util.List;
import java.util.stream.Collectors;

public class AutorDto {
    private Long id;
    private String nome;

    //se declara um construtor, precisamos declarar um vazio, se não tem nenhum construtor, é criado um vazio;
    // sem getter e setter para propriedades privadas dá erro

    public AutorDto() {
    }

    public AutorDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public AutorDto(Autor autor) {
        this.nome = autor.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<AutorDto> converter(List<Autor> autores) {
        return autores.stream()
                .map(a -> new AutorDto(a.getId(), a.getNome())
        ).collect(Collectors.toList());
    }
}
