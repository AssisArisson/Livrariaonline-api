package br.com.alura.livrariaonlineapi.controller;

import br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO;
import br.com.alura.livrariaonlineapi.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping("/livraria")
    public List<ItemLivrosDTO> relatorioLivros() {
        return service.relatorioLivros();
    }
}
