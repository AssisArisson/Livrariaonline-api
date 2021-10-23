
package br.com.alura.livrariaonlineapi.modelo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = {"curriculo"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String curriculo;

    public Autor(String nome, String email, LocalDate dataNascimento, String curriculo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.curriculo = curriculo;
    }

    public void atualizarAutor(String nome, String email, LocalDate dataNascimento, String curriculo) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.curriculo = curriculo;
    }

}
