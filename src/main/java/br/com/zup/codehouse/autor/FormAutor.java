package br.com.zup.codehouse.autor;

import br.com.zup.codehouse.shared.config.validation.beanvalidation.uniquevalue.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormAutor {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public FormAutor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail(){
        return this.email;
    }
}
