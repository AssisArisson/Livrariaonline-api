package br.com.alura.livrariaonlineapi.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginDTO {

    @NotBlank
    private String login;
    @NotBlank
    private  String senha;

}
