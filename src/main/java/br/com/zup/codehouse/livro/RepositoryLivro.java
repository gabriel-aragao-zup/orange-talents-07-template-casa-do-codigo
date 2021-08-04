package br.com.zup.codehouse.livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryLivro extends JpaRepository<Livro, Long> {
}
