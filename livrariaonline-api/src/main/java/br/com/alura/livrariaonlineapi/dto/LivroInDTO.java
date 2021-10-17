package br.com.alura.livrariaonlineapi.dto;

import br.com.alura.livrariaonlineapi.modelo.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
public class LivroInDTO {

    @Size(min = 10, max = 100, message = "Título deve ter entre 10 e 100 caracteres!")
    @NotBlank(message = "Título deve ser informado!")
    @JsonProperty("titulo_livro")
    private String titulo;

    @NotNull(message = "Data de lançamento deve ser informada!")
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("data_lancamento_livro")
    private LocalDate dataLancamento;

    @NotNull(message = "Número de páginas deve ser informado!")
    @Min(value = 100, message = "Número de páginas deve ser >= 100!")
    @JsonProperty("quantidade_pagina_livro")
    private Integer numeroPaginas;

    @JsonProperty("autor_livro")
    private AutorInDTO autor;

    @JsonProperty("autor_id")
    private Long autorId;

}
