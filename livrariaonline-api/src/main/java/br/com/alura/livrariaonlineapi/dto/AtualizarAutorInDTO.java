package br.com.alura.livrariaonlineapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AtualizarAutorInDTO extends AutorInDTO{

    @NotNull
    private Long id;

}
