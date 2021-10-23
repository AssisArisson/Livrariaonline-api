package br.com.alura.livrariaonlineapi.dto;

import br.com.alura.livrariaonlineapi.modelo.Autor;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LivroInDTO {

    @Size(min = 10, max = 100)
    @NotBlank
    @JsonProperty("titulo_livro")
    private String titulo;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("data_lancamento_livro")
    private LocalDate dataLancamento;

    @NotNull
    @Min(value = 100)
    @JsonProperty("quantidade_pagina_livro")
    private Integer numeroPaginas;

    @JsonProperty("autor_id")
    private Long autorId;

}
