package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.Autor;
import br.com.zup.codehouse.categoria.Categoria;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DTOLivro {
    private Long id;
    private String titulo;
    private BigDecimal preco;
    private int paginas;
    private String isbn;
    private String categoriaNome;
    private String autorNome;

    public DTOLivro(Long id, String titulo, BigDecimal preco, int paginas,
                    String isbn, String categoriaNome, String autorNome) {
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.categoriaNome = categoriaNome;
        this.autorNome = autorNome;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public String getAutorNome() {
        return autorNome;
    }
}
