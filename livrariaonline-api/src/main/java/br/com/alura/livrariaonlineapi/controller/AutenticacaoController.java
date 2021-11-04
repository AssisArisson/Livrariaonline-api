package br.com.alura.livrariaonlineapi.controller;


import br.com.alura.livrariaonlineapi.dto.LoginDTO;
import br.com.alura.livrariaonlineapi.dto.TokenDTO;
import br.com.alura.livrariaonlineapi.infra.security.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public TokenDTO autenticar(@RequestBody @Valid LoginDTO loginDTO){
        return new TokenDTO(autenticacaoService.autenticar(loginDTO));
    }

}
