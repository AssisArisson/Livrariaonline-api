package br.com.alura.livrariaonlineapi.controller;

import br.com.alura.livrariaonlineapi.dto.UsuarioInDTO;
import br.com.alura.livrariaonlineapi.dto.UsuarioOutDTO;
import br.com.alura.livrariaonlineapi.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "Usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @ApiOperation("Listar usuarios")
    public Page<UsuarioOutDTO> listar(@PageableDefault(size = 10) Pageable paginacao){

        return usuarioService.listar(paginacao);

    }

    @PostMapping
    @ApiOperation("Cadastrar novo usuarios")
    public ResponseEntity<UsuarioOutDTO> cadastrar(@RequestBody @Valid UsuarioInDTO usuarioInDTO, UriComponentsBuilder uriBuilder){

        UsuarioOutDTO usuarioOut = usuarioService.cadastrar(usuarioInDTO);

        URI uri = uriBuilder.path("/usuarios/{id}")
                .buildAndExpand(usuarioOut.getId())
                .toUri();
        return ResponseEntity.created(uri).body(usuarioOut);

    }

}
