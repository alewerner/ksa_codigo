package com.casadocodigo.basic.livraria.autor;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping( value = "/api/autores" )
    @Transactional
    public String criar( @RequestBody @Valid NovoAutorRequest request ) {

        Autor autor = request.toModel();
        autorRepository.save( autor );

        return autor.toString();
    }

    @GetMapping( value = "/api/autores/{nome}" )
    public AutorDto detalhar( @PathVariable String nome ) {
        Optional<Autor> autor = autorRepository.findByNome( nome );
        if ( autor.isPresent() ) {
            return new AutorDto( autor.get() );
        } else {
            throw new ResponseStatusException( HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping( value = "/api/autores/listarTodos" )
    public List<AutorDto> listarTodos() {
        List<Autor> autores = autorRepository.findAll();
        return AutorDto.converter( autores );
    }
}
