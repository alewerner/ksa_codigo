package com.casadocodigo.basic.livraria;

import com.casadocodigo.basic.livraria.livro.NovoLivroRequest;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TestMock {

    public static NovoLivroRequest getRequest() {
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
