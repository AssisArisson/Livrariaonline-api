package br.com.alura.livrariaonlineapi.service;

import br.com.alura.livrariaonlineapi.dto.LivroInDTO;
import br.com.alura.livrariaonlineapi.dto.LivroOutDTO;
import br.com.alura.livrariaonlineapi.modelo.Livro;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LivroService {

    private List<Livro> livros = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<LivroOutDTO> listar() {
        return livros
                .stream()
                .map(l -> modelMapper.map(l, LivroOutDTO.class))
                .collect(Collectors.toList());
    }

    public void cadastrar(LivroInDTO livroInDTO){
        Livro livro = modelMapper.map(livroInDTO, Livro.class);

        livros.add(livro);

    }
}
