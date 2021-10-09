package br.com.alura.livrariaonlineapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class ItemLivrosDTO {

    private String autor;
    private Integer quantidadeLivros;
    private Double percentual;
}
