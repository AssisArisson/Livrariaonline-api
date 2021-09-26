package br.com.alura.livrariaonlineapi.service;

import br.com.alura.livrariaonlineapi.dto.AutorInDTO;
import br.com.alura.livrariaonlineapi.dto.AutorOutDTO;
import br.com.alura.livrariaonlineapi.modelo.Autor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private List<Autor> autores = new ArrayList<>();
    private ModelMapper modelMapper = new ModelMapper();

    public List<AutorOutDTO> listar(){
        return autores
                .stream()
                .map(a -> modelMapper.map(a, AutorOutDTO.class))
                .collect(Collectors.toList());
    }

    public void cadastrar(AutorInDTO autorInDTO){
        Autor autor = modelMapper.map(autorInDTO, Autor.class);

        autores.add(autor);

    }
}
