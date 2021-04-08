package com.casadocodigo.basic.livraria.categoria;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    @PostMapping( value = "/api/categoria" )
    public String cadastrarCategoria( @RequestBody @Valid NovaCategoriaRequest request ) {
        Categoria categoria = request.converter( categoriaRepository );
        categoriaRepository.save( categoria );

        return categoria.toString();
    }

    @GetMapping( value = "/api/categoria/{nome}" )
    public CategoriaDto listarCategoria( @PathVariable String nome ) {
        Optional<Categoria> categoria = categoriaRepository.findByNome( nome );
        if ( categoria.isPresent() ){
            return new CategoriaDto( categoria.get() );
        }else{
            throw new ResponseStatusException( HttpStatus.NOT_FOUND );
        }
    }
}
