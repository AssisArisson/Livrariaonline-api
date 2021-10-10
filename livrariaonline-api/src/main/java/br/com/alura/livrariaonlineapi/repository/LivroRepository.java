package br.com.alura.livrariaonlineapi.repository;


import br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO;
import br.com.alura.livrariaonlineapi.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select new br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO("
            + "a.autor.nome, "
            + "sum(a.quantidadeLivros), "
            + "sum(a.quantidadeLivros) * 1.0 / (select sum(a2.quantidadeLivros) from Livro a2) * 1.0 ) "
            + "from Livro a "
            + "group by a.autor")
    List<ItemLivrosDTO> relatorioLivros();
}
