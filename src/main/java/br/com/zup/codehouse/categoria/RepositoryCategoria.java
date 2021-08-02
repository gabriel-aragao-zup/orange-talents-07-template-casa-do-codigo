package br.com.zup.codehouse.categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryCategoria extends JpaRepository<Categoria, Long>{
    Optional<Categoria> findByNome(String nome);
}
