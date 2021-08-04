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

    /*
     * esse setter foi criado por uma limitação no jackson de desserializar JSONs com apenas um atributo através de um construtor.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

}
