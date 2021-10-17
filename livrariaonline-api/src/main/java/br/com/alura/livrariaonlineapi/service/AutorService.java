package br.com.alura.livrariaonlineapi.service;

import br.com.alura.livrariaonlineapi.dto.AutorInDTO;
import br.com.alura.livrariaonlineapi.dto.AutorOutDTO;
import br.com.alura.livrariaonlineapi.modelo.Autor;
import br.com.alura.livrariaonlineapi.repository.AutorRepository;
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
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public Page<AutorOutDTO> listar(Pageable pageable){
        Page<Autor> autores = autorRepository.findAll(pageable);
        return autores
                .map(a -> modelMapper.map(a, AutorOutDTO.class));
    }

    @Transactional
    public AutorOutDTO cadastrar(AutorInDTO autorInDTO){
        Autor autor = modelMapper.map(autorInDTO, Autor.class);

        autor.setId(null);

        autorRepository.save(autor);

        return modelMapper.map(autor, AutorOutDTO.class);

    }
}
