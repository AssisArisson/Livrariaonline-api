package br.com.alura.livrariaonlineapi.repository;

import br.com.alura.livrariaonlineapi.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository  extends JpaRepository<Autor, Long>{

}
