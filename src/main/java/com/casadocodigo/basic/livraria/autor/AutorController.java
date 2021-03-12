package com.casadocodigo.basic.livraria.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/api/autores")
    @Transactional
    public String criar(@RequestBody NovoAutorRequest request) {

        Autor autor = request.toModel();
        autorRepository.save(autor);

        return  autor.toString();
    }
}
