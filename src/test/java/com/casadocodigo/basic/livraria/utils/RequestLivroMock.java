package com.casadocodigo.basic.livraria.utils;

import com.casadocodigo.basic.livraria.livro.NovoLivroRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RequestLivroMock {

    public static NovoLivroRequest getRequestNovoLivro() {
        NovoLivroRequest novoLivroRequest = new NovoLivroRequest(
            "resumo",
            "sumario",
            BigDecimal.valueOf( 3.33 ),
            888,
            "isbn",
            LocalDate.now(),
            1L,
            1L,
            "titulo"
        );

        return novoLivroRequest;
    }
}
