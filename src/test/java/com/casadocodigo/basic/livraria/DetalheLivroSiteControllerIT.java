package com.casadocodigo.basic.livraria;

import com.casadocodigo.basic.livraria.utils.CustomMockMvc;
import com.casadocodigo.basic.livraria.utils.RequestLivroMock;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DetalheLivroSiteControllerIT {

    @Autowired
    private CustomMockMvc mvc;

    @Test
    @DisplayName("exibe detalhes do livro corretamente")
    public void teste1() throws Exception {
        mvc.post("/api/autores", Map.of("nome", "alberto", "email",
                "testetesteteste@gmail.com", "descricao", "descricao1231312123"));

        mvc.post("/api/categoria", Map.of("nome", "categoria", "descricao", "categoria 12 123123"));

        BigDecimal valorLivro = new BigDecimal("20");
        String titulo = "titulo";
        String resumo = "resumo resumo resumo resumo resumo resumo resumo";
        String sumario = "sumario";
        int numeroPaginas = 1001;
        String isbn = "1234567890";
        String dataPublicacao = LocalDate.now().plusDays(1)
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        // mvc.post("/api/livros", (Map<String, Object>) RequestLivroMock.getRequestNovoLivro());

        mvc.post("/api/livros",
                Map.of("titulo", titulo, "resumo", resumo, "sumario", sumario,
                        "preco", valorLivro.toString(), "numeroPaginas",
                        numeroPaginas, "isbn", isbn, "dataPublicacao",
                        dataPublicacao, "idCategoria", "1", "idAutor", "1"));

        ResultActions resultado = mvc.get("/produtos/1");

        Map<String, Object> autor = Map.of("nome", "alberto", "descricao", "descricao");
        Map<String, Object> detalheLivro = Map.of(
                "titulo", titulo,
                "isbn", isbn,
                "numeroPaginas", numeroPaginas,
                "preco", valorLivro.setScale(2),
                "resumo", resumo,
                "sumario", sumario,
                "dataPublicacao", dataPublicacao,
                "autor", autor);

        String jsonEsperado = new ObjectMapper()
                .writeValueAsString(detalheLivro);
        resultado.andExpect(MockMvcResultMatchers.content().json(jsonEsperado));

    }
}