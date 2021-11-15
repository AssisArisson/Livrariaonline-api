package br.com.alura.livrariaonlineapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioOutDTO {

    private Long id;
    private String nome;
    private String login;

}
