package br.com.alura.livrariaonlineapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Getter
@Setter
public class AutorInDTO {

    @NotBlank(message = "Nome deve ser informado!")
    @JsonProperty("nome")
    private String nome;

    @NotBlank(message = "Email deve ser informado!")
    @JsonProperty("email")
    private String email;

    @NotNull(message = "Data de nascimento deve ser informada!")
    @Past(message = "Data de nascimento deve ser menor a hoje!")
    @JsonProperty("data_nascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotBlank(message = "Mini currículo deve ser informado!")
    @JsonProperty("curriculo")
    private String curriculo;

}
