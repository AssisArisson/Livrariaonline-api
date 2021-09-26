package br.com.alura.livrariaonlineapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
public class AutorInDTO {

    @NotBlank
    @JsonProperty("nome")
    private String nome;

    @NotBlank
    @JsonProperty("email")
    private String email;

    @Past
    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @NotBlank
    @JsonProperty("curriculo")
    private String curriculo;

}
