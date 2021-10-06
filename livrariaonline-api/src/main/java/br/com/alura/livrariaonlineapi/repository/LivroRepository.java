package br.com.alura.livrariaonlineapi.repository;


import br.com.alura.livrariaonlineapi.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
