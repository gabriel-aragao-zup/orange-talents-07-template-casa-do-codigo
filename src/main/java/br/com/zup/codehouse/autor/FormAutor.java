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


    public Autor toModel(){
        return new Autor(this.nome, this.email, this.descricao);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail(){
        return this.email;
    }
}
