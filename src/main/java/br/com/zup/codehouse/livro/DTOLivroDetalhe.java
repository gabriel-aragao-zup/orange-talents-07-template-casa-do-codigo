package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.Autor;
import br.com.zup.codehouse.categoria.Categoria;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

public class DTOLivroDetalhe {

    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private int paginas;
    private String isbn;
    private String autor;

    public DTOLivroDetalhe(String titulo, String resumo, String sumario,
                           BigDecimal preco, int paginas, String isbn, String autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
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

    public String getAutor() {
        return autor;
    }
}
