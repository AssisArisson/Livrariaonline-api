package br.com.alura.livrariaonlineapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemLivrosDTO {

    private String autor;
    private Long quantidadeLivros;
    private Double percentual;
}
