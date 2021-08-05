package br.com.zup.codehouse.pais;

import br.com.zup.codehouse.shared.config.validation.beanvalidation.uniquevalue.UniqueValue;

import javax.validation.constraints.NotBlank;

public class FormPais {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public Pais toModel(){
        return new Pais(this.nome);
    }

    public String getNome() {
        return nome;
    }

    /*
     * Setter criado por limitação do jackson em desserializar um objeto via construtor quando o json só possui um campo.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
