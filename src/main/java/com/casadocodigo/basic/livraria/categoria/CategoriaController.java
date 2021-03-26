package com.casadocodigo.basic.livraria.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping(value = "api/categoria")
    public String nova(@RequestBody @Valid NovaCategoriaRequest request) {

        Categoria novaCategoria = new Categoria(request.getNome());
        categoriaRepository.save(novaCategoria);

        return novaCategoria.toString();
    }
}
