package br.com.alura.livrariaonlineapi.modelo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private LocalDate dataLancamento;
    private Integer numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Livro(String titulo, LocalDate dataLancamento, Integer numeroPaginas, Autor autor) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
    }
}
