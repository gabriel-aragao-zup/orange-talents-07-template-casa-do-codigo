package br.com.zup.codehouse.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class DTOAutor {

    private long id;
    private String nome;
    private String descricao;

    private DTOAutor(Long id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static DTOAutor from(Autor autor){
        return new DTOAutor(autor.getId(), autor.getNome(), autor.getDescricao());
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
