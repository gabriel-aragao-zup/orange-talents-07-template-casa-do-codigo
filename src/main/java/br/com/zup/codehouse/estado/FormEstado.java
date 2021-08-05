package br.com.zup.codehouse.estado;

import br.com.zup.codehouse.pais.Pais;
import br.com.zup.codehouse.pais.RepositoryPais;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.existsid.ExistsId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class FormEstado {

    @NotBlank
    private String nome;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;


    public Estado toModel(RepositoryPais repositoryPais){
        Optional<Pais> optionalPais = repositoryPais.findById(this.paisId);
        if(optionalPais.isPresent()){
            return new Estado(this.nome, optionalPais.get());
        }
        throw new IllegalStateException();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public String getNome() {
        return nome;
    }

    public Long getPaisId() {
        return paisId;
    }
}
