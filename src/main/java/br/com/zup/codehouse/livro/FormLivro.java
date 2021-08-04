package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.Autor;
import br.com.zup.codehouse.autor.RepositoryAutor;
import br.com.zup.codehouse.categoria.Categoria;
import br.com.zup.codehouse.categoria.RepositoryCategoria;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.existsid.ExistsId;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.uniquevalue.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.ManyToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class FormLivro {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull
    @Min(100)
    private int paginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;

    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id")
    private Long autorId;


    public FormLivro(String titulo, String resumo, String sumario, BigDecimal preco,
                     int paginas, String isbn,
                     Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toModel(RepositoryAutor repositoryAutor, RepositoryCategoria repositoryCategoria){
        Autor autor = repositoryAutor.getById(this.autorId);
        Categoria categoria = repositoryCategoria.getById(this.categoriaId);

        return new Livro(this.titulo, this.resumo, this.sumario, this.preco, this.paginas, this.isbn, this.dataPublicacao, categoria, autor);
    }

    /*
     * set criado por restrições do jackson quanto a desserialização de atributos do tipo localdate via construtor
     */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
