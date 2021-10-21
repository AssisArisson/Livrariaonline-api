package br.com.alura.livrariaonlineapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Getter
public class ItemLivrosDTO {

    private String autor;
    private Long quantidadeLivros;
    private BigDecimal percentual;

    public ItemLivrosDTO(String autor, Long quantidadeLivros, Long quantidadeTotal) {
        this.autor = autor;
        this.quantidadeLivros = quantidadeLivros;
        this.percentual = new BigDecimal(quantidadeLivros)
                .divide(new BigDecimal(quantidadeTotal), 4, RoundingMode.HALF_UP)
                .multiply(new BigDecimal("100"))
                .setScale(2);
    }
}
