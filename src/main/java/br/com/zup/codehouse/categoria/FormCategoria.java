package br.com.zup.codehouse.categoria;

import br.com.zup.codehouse.shared.config.validation.beanvalidation.uniquevalue.UniqueValue;

import javax.validation.constraints.NotBlank;

public class FormCategoria{

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    public Categoria toModel(){
        return new Categoria(this.nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
