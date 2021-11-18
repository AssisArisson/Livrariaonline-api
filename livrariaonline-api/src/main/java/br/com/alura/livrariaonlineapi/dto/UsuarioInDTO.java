package br.com.alura.livrariaonlineapi.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioInDTO {

    @NotBlank
    private String nome;

    @NotBlank
    private String login;

    @NotNull
    private Long perfilId;
}
