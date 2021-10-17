package br.com.alura.livrariaonlineapi.service;

import br.com.alura.livrariaonlineapi.dto.LivroInDTO;
import br.com.alura.livrariaonlineapi.dto.LivroOutDTO;
import br.com.alura.livrariaonlineapi.modelo.Autor;
import br.com.alura.livrariaonlineapi.modelo.Livro;
import br.com.alura.livrariaonlineapi.repository.AutorRepository;
import br.com.alura.livrariaonlineapi.repository.LivroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    public Page<LivroOutDTO> listar(Pageable paginacao) {

        Page<Livro> livros = livroRepository.findAll(paginacao);

        return livros.map(l -> modelMapper.map(l, LivroOutDTO.class));
    }

    @Transactional
    public LivroOutDTO cadastrar(LivroInDTO livroInDTO){
        Livro livro = modelMapper.map(livroInDTO, Livro.class);

        Autor autor  = autorRepository.getById(livroInDTO.getAutorId());

        livro.setId(null);

        livro.setAutor(autor);

        livroRepository.save(livro);

        return modelMapper.map(livro, LivroOutDTO.class);

    }
}
