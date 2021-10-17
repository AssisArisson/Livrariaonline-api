package br.com.alura.livrariaonlineapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;


@Getter
@Setter
public class LivroOutDTO {


    private Long id;
    private String titulo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataLancamento;
    private Integer numeroPaginas;
    private AutorOutDTO autor;
}
