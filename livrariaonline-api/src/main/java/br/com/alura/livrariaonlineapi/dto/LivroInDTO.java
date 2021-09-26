package br.com.alura.livrariaonlineapi.dto;

import br.com.alura.livrariaonlineapi.modelo.Autor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;


@Getter
@Setter
public class LivroInDTO {

    @Size(min=10)
    @NotBlank
    @JsonProperty("titulo_livro")
    private String titulo;

    @PastOrPresent
    @JsonProperty("data_lancamento_livro")
    private LocalDate dataLancamento;

    @Min(100)
    @JsonProperty("quantidade_pagina_livro")
    private Integer numeroPaginas;

    @JsonProperty("autor_livro")
    private AutorInDTO autor;

}
