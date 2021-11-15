package com.casadocodigo.basic.livraria.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ConsultaLivroController {

    @Autowired
    private BuscaLivroService buscaLivroService;

    @GetMapping(value = "/produtos/{id}")
    public ResponseEntity<?> getLivro(@PathVariable("id") Long id) {

        Optional<DetalheLivroSiteReponse> livroOptional = buscaLivroService.getLivroERetornaReponse(id);

        if (livroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        DetalheLivroSiteReponse detalheLivroSiteReponse = livroOptional.get();
        return ResponseEntity.ok(detalheLivroSiteReponse);
    }

    @GetMapping(value = "/produtosLivro/{id}")
    public Livro getLivro2(@PathVariable("id") Long id) {
        return buscaLivroService.getLivroPorId(id).get();
    }

}
