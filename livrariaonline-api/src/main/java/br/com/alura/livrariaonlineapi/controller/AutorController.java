package br.com.alura.livrariaonlineapi.controller;

import br.com.alura.livrariaonlineapi.dto.AtualizarAutorInDTO;
import br.com.alura.livrariaonlineapi.dto.AutorInDTO;
import br.com.alura.livrariaonlineapi.dto.AutorOutDTO;
import br.com.alura.livrariaonlineapi.dto.DetalhesAutorOutDTO;
import br.com.alura.livrariaonlineapi.service.AutorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autores")
@Api(tags = "Autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    @ApiOperation("Listar Autores")
    public Page<AutorOutDTO> listar(@PageableDefault(size = 10) Pageable paginacao){

        return autorService.listar(paginacao);

    }

    @PostMapping
    @ApiOperation("Cadastrar novo Autor")
    public ResponseEntity<AutorOutDTO> cadastrar(@RequestBody @Valid AutorInDTO autorInDTO,
              UriComponentsBuilder uriBuilder){

        AutorOutDTO autorDTO = autorService.cadastrar(autorInDTO);

        URI uri = uriBuilder.path("/autores/{id}")
                .buildAndExpand(autorDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).body(autorDTO);

    }

    @PutMapping
    @ApiOperation("Atualizar Autores")
    public ResponseEntity<AutorOutDTO> atualizar(@RequestBody @Valid AtualizarAutorInDTO atualizarAutorInDTO){

        AutorOutDTO atualizado = autorService.atualizar(atualizarAutorInDTO);

        return ResponseEntity.ok(atualizado);

    }

    @DeleteMapping("{id}")
    @ApiOperation("Remover Autores")
    public ResponseEntity<AutorOutDTO> remover(@PathVariable @NotNull Long id){
        autorService.remover(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @ApiOperation("Detalhar Autores")
    public ResponseEntity<DetalhesAutorOutDTO> detalhar(@PathVariable @NotNull Long id){

      DetalhesAutorOutDTO  detalhesAutorOutDTO = autorService.detalhar(id);

      return ResponseEntity.ok(detalhesAutorOutDTO);

    }

}
