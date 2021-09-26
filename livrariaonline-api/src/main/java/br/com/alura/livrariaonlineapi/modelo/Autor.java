
package br.com.alura.livrariaonlineapi.modelo;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString(exclude = {"curriculo"})
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String curriculo;
}
