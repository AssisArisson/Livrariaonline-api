package br.com.alura.livrariaonlineapi.modelo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Livro {

    private String titulo;
    private LocalDate dataLancamento;
    private Integer numeroPaginas;
    private Autor autor;

}
