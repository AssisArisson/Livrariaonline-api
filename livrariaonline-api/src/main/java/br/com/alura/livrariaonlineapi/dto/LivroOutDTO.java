package br.com.alura.livrariaonlineapi.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
public class LivroOutDTO {

    private String titulo;
    private LocalDate dataLancamento;
    private Integer numeroPaginas;
    private AutorOutDTO autor;
}
