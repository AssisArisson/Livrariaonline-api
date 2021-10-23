package br.com.alura.livrariaonlineapi.controller;

import br.com.alura.livrariaonlineapi.modelo.Autor;
import br.com.alura.livrariaonlineapi.repository.AutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class LivroControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private AutorRepository autorRepository;

    @Test
    void cadastrarLivroscomDadosImcompletos() throws Exception {
        String json = "{}";

        mvc
                .perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void cadastrarLivroscomDadosCompletos() throws Exception {
        Autor autor = new Autor();
        autor.setNome("Mario Bros");
        autor.setEmail("mario@gmail.com");
        autor.setDataNascimento(LocalDate.of(1989, 06, 16));
        autor.setCurriculo("Sou U Milhór");
        autor.setId(null);
        autorRepository.save(autor);

        String json = "{\"titulo_livro\":\"Testes unitarios\", \"data_lancamento_livro\":\"05/10/2004\", \"quantidade_pagina_livro\":100, \"autor_id\":"+ autor.getId() + "}";
        String jsonRetorno = "{\"titulo\":\"Testes unitarios\", \"dataLancamento\":\"05/10/2004\", \"numeroPaginas\":100 }";

        mvc
                .perform(post("/livros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(MockMvcResultMatchers.content().json(jsonRetorno));
    }
}