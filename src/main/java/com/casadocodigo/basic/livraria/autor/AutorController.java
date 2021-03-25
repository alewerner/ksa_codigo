package com.casadocodigo.basic.livraria.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @PostMapping(value = "/api/autores")
    @Transactional
    public String criar(@Valid @RequestBody NovoAutorRequest request) {

        Autor autor = request.toModel();
        autorRepository.save(autor);

        return autor.toString();
    }

    @GetMapping(value = "/api/autores/{nome}")
    public String detalhar(@PathVariable String nome) {
        Optional<Autor> autor = autorRepository.findByNome(nome);

        if (autor.isPresent()) {

            return autor.get().toString();
        }

        return "Autor não encontrado";
    }

    @GetMapping(value = "/api/autores/listarTodos")
    public List<AutorDto> listarTodos() {
        List<Autor> autores = autorRepository.findAll();

        return AutorDto.converter(autores);
        //return autores.toString();
    }
}
