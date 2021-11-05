package br.com.alura.livrariaonlineapi.repository;

import br.com.alura.livrariaonlineapi.modelo.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
