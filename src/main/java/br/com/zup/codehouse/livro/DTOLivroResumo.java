package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.Autor;
import br.com.zup.codehouse.categoria.Categoria;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DTOLivroResumo {
    private Long id;
    private String titulo;


    public DTOLivroResumo(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

}
