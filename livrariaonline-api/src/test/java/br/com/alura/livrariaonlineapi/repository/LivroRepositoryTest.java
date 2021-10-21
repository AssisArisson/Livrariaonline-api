package br.com.alura.livrariaonlineapi.repository;

import br.com.alura.livrariaonlineapi.modelo.Autor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

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
                1l,
                "Andre da Silva",
                "andre@gmail.com",
                LocalDate.of(1990, 10, 20),
                "Sou U Milhór"
        );

        entityManager.persist(autor1);

        Autor autor2 = new Autor(
                2l,
                "Fernanda Nogueira",
                "fernanda@gmail.com",
                LocalDate.of(2000, 05, 06),
                "Sou U Milhór"
        );

        entityManager.persist(autor2);

        Autor autor3 = new Autor(
                3l,
                "Juliana Carvalho",
                "juliana@gmail.com",
                LocalDate.of(1998, 07, 20),
                "Sou U Milhór"
        );

        entityManager.persist(autor3);

        Autor autor4 = new Autor(
                4l,
                "Rita de Assis",
                "rita@gmail.com",
                LocalDate.of(1970, 05, 02),
                "Sou U Milhór"
        );

        entityManager.persist(autor4);

        Autor autor5 = new Autor(
                5l,
                "Rodrigo Souza",
                "rodrigo@gmail.com",
                LocalDate.of(1989, 05, 18),
                "Sou U Milhór"
        );

        entityManager.persist(autor5);

    }

}
