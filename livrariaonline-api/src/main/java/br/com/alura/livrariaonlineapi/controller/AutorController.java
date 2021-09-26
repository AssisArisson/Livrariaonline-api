package br.com.alura.livrariaonlineapi.controller;

import br.com.alura.livrariaonlineapi.dto.AutorInDTO;
import br.com.alura.livrariaonlineapi.dto.AutorOutDTO;
import br.com.alura.livrariaonlineapi.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping
    public List<AutorOutDTO> listar(){

        return autorService.listar();

    }

    @PostMapping
    public void cadastrar(@RequestBody @Valid AutorInDTO autorInDTO){

        autorService.cadastrar(autorInDTO);

    }

}
