package com.casadocodigo.basic.livraria.categoria;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    @PostMapping( value = "/api/categoria/criar" )
    public String cadastrarCategoria( @RequestBody NovaCategoriaRequest request ) {
        Categoria categoria = request.converter( categoriaRepository );
        categoriaRepository.save( categoria );

        return categoria.toString();
    }

    @GetMapping( value = "/api/categoria/{nome}" )
    public CategoriaDto listarCategoria( @RequestParam @PathVariable String nome ) {
        Categoria categoria = categoriaRepository.findByNome(nome);
        return new CategoriaDto(categoria);
    }
}
