package br.com.alura.livrariaonlineapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AutorOutDTO {

    private String nome;
    private String email;
    private LocalDate dataNascimento;

}
