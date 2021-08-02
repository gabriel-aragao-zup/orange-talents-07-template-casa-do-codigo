package br.com.zup.codehouse.categoria;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FormCategoria {

    @NotBlank
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
