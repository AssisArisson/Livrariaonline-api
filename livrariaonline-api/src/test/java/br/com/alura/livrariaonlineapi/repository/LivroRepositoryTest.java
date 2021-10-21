package br.com.alura.livrariaonlineapi.repository;

import br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO;
import br.com.alura.livrariaonlineapi.modelo.Autor;
import br.com.alura.livrariaonlineapi.modelo.Livro;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class LivroRepositoryTest {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void retornarRelatorioDeLivros(){

        Autor autor1 = new Autor(
                "Andre Da Silva",
                "andre@gmail.com",
                LocalDate.of(1990, 10, 20),
                "Sou U Milhór"
        );

        Livro livro1 = new Livro(
                "Aprenda Java em 21 dias",
                LocalDate.of(2004,03,12),
                100,
                autor1
        );

        Livro livro2 = new Livro(
                "Aprenda Python em 12 dias",
                LocalDate.of(2012,01,01),
                100,
                autor1
        );

        entityManager.persist(autor1);
        entityManager.persist(livro1);
        entityManager.persist(livro2);

        Autor autor2 = new Autor(
                 "Fernanda Nogueira",
                "fernanda@gmail.com",
                LocalDate.of(2000, 05, 06),
                "Sou U Milhór"
        );

        Livro livro3 = new Livro(
                "Otimizando seu tempo",
                LocalDate.of(2004,12,21),
                100,
                autor2
        );

        Livro livro4 = new Livro(
                "Como ser mais produtivo",
                LocalDate.of(2004,04,10),
                100,
                autor2
        );

        entityManager.persist(autor2);
        entityManager.persist(livro3);
        entityManager.persist(livro4);

        Autor autor3 = new Autor(
               "Juliana Carvalho",
                "juliana@gmail.com",
                LocalDate.of(1998, 07, 20),
                "Sou U Milhór"
        );

        Livro livro5 = new Livro(
                "Aprenda a falar em publico",
                LocalDate.of(2004,07,01),
                100,
                autor3
        );

        entityManager.persist(autor3);
        entityManager.persist(livro5);

        Autor autor4 = new Autor(
                "Rita De Assis",
                "rita@gmail.com",
                LocalDate.of(1970, 05, 02),
                "Sou U Milhór"
        );

        Livro livro6 = new Livro(
                "Como fazer bolos incriveis",
                LocalDate.of(2008,9,12),
                100,
                autor4
        );

        entityManager.persist(autor4);
        entityManager.persist(livro6);

        Autor autor5 = new Autor(
                "Rodrigo De Souza",
                "rodrigo@gmail.com",
                LocalDate.of(1989, 05, 18),
                "Sou U Milhór"
        );

        Livro livro7 = new Livro(
                "Investindo em ações",
                LocalDate.of(2012,01,01),
                100,
                autor5
        );

        entityManager.persist(autor5);
        entityManager.persist(livro7);

        List<ItemLivrosDTO> relatorio = livroRepository.relatorioLivros();
        Assertions
                .assertThat(relatorio)
                .hasSize(5)
                .extracting(ItemLivrosDTO::getAutor, ItemLivrosDTO::getQuantidadeLivros, ItemLivrosDTO::getPercentual)
                .containsExactlyInAnyOrder(
                        Assertions.tuple("Andre Da Silva", 2l, new BigDecimal("0.28571")),
                        Assertions.tuple("Fernanda Nogueira", 2l, new BigDecimal("0.28571")),
                        Assertions.tuple("Juliana Carvalho", 1l, new BigDecimal("0.14286")),
                        Assertions.tuple("Rita De Assis", 1l, new BigDecimal("0.14286")),
                        Assertions.tuple("Rodrigo De Souza", 1l, new BigDecimal("0.14286"))
                );

    }

}
