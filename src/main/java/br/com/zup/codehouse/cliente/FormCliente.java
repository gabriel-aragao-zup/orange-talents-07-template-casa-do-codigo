package br.com.zup.codehouse.cliente;

import br.com.zup.codehouse.estado.Estado;
import br.com.zup.codehouse.estado.RepositoryEstado;
import br.com.zup.codehouse.pais.Pais;
import br.com.zup.codehouse.pais.RepositoryPais;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.cpforcnpj.CPFOrCNPJ;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.existsid.ExistsId;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.uniquevalue.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class FormCliente {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPFOrCNPJ
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id")
    private Long paisId;
    private Long estadoId;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public FormCliente() {
    }

    public FormCliente(String email, String nome, String sobrenome,
                       String documento, String endereco, String complemento,
                       String cidade, Long paisId, String telefone, String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente toModel(RepositoryPais repositoryPais, RepositoryEstado repositoryEstado) {
        Pais pais = repositoryPais.findById(this.paisId).get();

        Cliente cliente = new Cliente(this.email, this.nome, this.sobrenome, this.documento,
                this.endereco, this.complemento, this.cidade, pais, this.telefone, this.cep);

        if(this.estadoId != null){
            Estado estado = repositoryEstado.findById(estadoId).get();
            cliente.setEstado(estado);
        }

        return cliente;
    }

    public Long getPaisId() {
        return paisId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
