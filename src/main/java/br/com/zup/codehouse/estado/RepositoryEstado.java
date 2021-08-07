package br.com.zup.codehouse.estado;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryEstado extends JpaRepository<Estado, Long> {

    Optional<Estado> findByNomeAndPais_Id(String nome, Long paisId);

    List<Estado> findByPais_Id(Long paisId);
}
