package br.com.alura.livrariaonlineapi.repository;


import br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO;
import br.com.alura.livrariaonlineapi.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select new br.com.alura.livrariaonlineapi.dto.ItemLivrosDTO("
            + "a.nome, "
            + "count(l), "
            + "(count(l) * 1.0 / (select count(l2) * 1.0 from Livro l2))) "
            + "from Livro l "
            + "join l.autor a "
            + "group by a.nome")
    List<ItemLivrosDTO> relatorioLivros();
}
