package br.com.alura.livrariaonlineapi.service;

import br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO;
import br.com.alura.livrariaonlineapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    private LivroRepository livroRepository;

    public List<ItemLivrosDTO> relatorioLivros() {
        return livroRepository.relatorioLivros();
    }
}
