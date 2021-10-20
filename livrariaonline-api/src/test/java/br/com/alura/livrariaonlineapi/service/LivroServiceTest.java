package br.com.alura.livrariaonlineapi.service;

import br.com.alura.livrariaonlineapi.dto.LivroInDTO;
import br.com.alura.livrariaonlineapi.dto.LivroOutDTO;
import br.com.alura.livrariaonlineapi.repository.AutorRepository;
import br.com.alura.livrariaonlineapi.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {

    @InjectMocks
    private LivroService livroService;

    @Mock
    private LivroRepository livroRepository;

    @Mock
    private AutorRepository autorRepository;

    public LivroInDTO criarObjetoLivroInDto(){
        LivroInDTO livro = new LivroInDTO(
                "Testes com Junit",
                LocalDate.now(),
                100,
                1l
        );
        return livro;
    }


    @Test
    void deveCadastrarUmLivro() {

        LivroInDTO livro = criarObjetoLivroInDto();

        LivroOutDTO livroOutDTO = livroService.cadastrar(livro);

        Mockito.verify(livroRepository).save(Mockito.any());

        assertEquals(livro.getTitulo(), livroOutDTO.getTitulo());
        assertEquals(livro.getDataLancamento(), livroOutDTO.getDataLancamento());
        assertEquals(livro.getNumeroPaginas(), livroOutDTO.getNumeroPaginas());

    }

}