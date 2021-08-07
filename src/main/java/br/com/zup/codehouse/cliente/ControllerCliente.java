package br.com.zup.codehouse.cliente;

import br.com.zup.codehouse.estado.RepositoryEstado;
import br.com.zup.codehouse.pais.RepositoryPais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ControllerCliente {

    private RepositoryCliente repositoryCliente;
    private RepositoryPais repositoryPais;
    private RepositoryEstado repositoryEstado;
    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;

    public ControllerCliente(RepositoryCliente repositoryCliente,
                             RepositoryPais repositoryPais,
                             RepositoryEstado repositoryEstado) {
        this.repositoryCliente = repositoryCliente;
        this.repositoryPais = repositoryPais;
        this.repositoryEstado = repositoryEstado;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(estadoPertenceAPaisValidator);
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody @Valid FormCliente formCliente){
        Cliente cliente = formCliente.toModel(repositoryPais, repositoryEstado);
        repositoryCliente.save(cliente);
        return ResponseEntity.ok().body(cliente);
    }
}
