package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.Autor;
import br.com.zup.codehouse.categoria.Categoria;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(length = 500)
    private String resumo;
    @Column(columnDefinition = "CLOB")
    private String sumario;
    private BigDecimal preco;
    private int paginas;
    private String isbn;
    private LocalDate dataPublicacao;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    private Livro(){
    }

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 int paginas, String isbn, LocalDate dataPublicacao,
                 Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public DTOLivro toDTO(){
        return new DTOLivro(this.id, this.titulo);
    }
    public Long getId() {
        return id;
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

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
