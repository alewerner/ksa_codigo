package com.casadocodigo.basic.livraria.autor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/api/autores")
    @Transactional
    public String criar(@Valid @RequestBody NovoAutorRequest request) {

        Autor autor = request.toModel();
        autorRepository.save(autor);

        return  autor.toString();
    }

    @GetMapping(value= "/api/autores/{nome}")
    public AutorDto detalhar(@RequestParam @PathVariable String nome){
        Autor autor = autorRepository.findByNome(nome);
        return new AutorDto(autor);
    }

    @GetMapping(value="/api/autores/listarTodos")
    public List<AutorDto> listarTodos(){
        List<Autor> autores = autorRepository.findAll();
        return AutorDto.converter(autores);
    }
}
