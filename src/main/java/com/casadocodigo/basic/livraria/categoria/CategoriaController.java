package com.casadocodigo.basic.livraria.categoria;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoriaController {

    @PostMapping(value = "api/categoria")
    public void nova(@RequestBody @Valid NovaCategoriaRequest novaCategoriaRequest) {

    }
}
