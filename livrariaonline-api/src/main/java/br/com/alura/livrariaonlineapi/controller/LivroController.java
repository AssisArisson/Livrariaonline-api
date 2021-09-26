package br.com.alura.livrariaonlineapi.controller;

import br.com.alura.livrariaonlineapi.dto.LivroInDTO;
import br.com.alura.livrariaonlineapi.dto.LivroOutDTO;
import br.com.alura.livrariaonlineapi.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public List<LivroOutDTO> listar(){
        return livroService.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid LivroInDTO livroInDTO){

        livroService.cadastrar(livroInDTO);

    }
}
