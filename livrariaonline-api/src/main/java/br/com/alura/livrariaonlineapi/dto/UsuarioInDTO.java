package br.com.alura.livrariaonlineapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioInDTO {

    @NotBlank
    @JsonProperty("nome_usuario")
    private String nome;

    @NotBlank
    @JsonProperty("login_usuario")
    private String login;

    @NotNull
    @JsonProperty("id_perfil")
    private Long perfilId;
}
