package br.com.zup.codehouse.estado;

import br.com.zup.codehouse.pais.RepositoryPais;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/estados")
public class ControllerEstado {

    private RepositoryEstado repositoryEstado;
    private RepositoryPais repositoryPais;
    @Autowired
    private EstadoDuplicadoEmUmPaisValidator estadoDuplicadoEmUmPaisValidator;

    public ControllerEstado(RepositoryEstado repositoryEstado, RepositoryPais repositoryPais) {
        this.repositoryEstado = repositoryEstado;
        this.repositoryPais = repositoryPais;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(estadoDuplicadoEmUmPaisValidator);
    }
    @PostMapping
    public ResponseEntity<Estado> createEstado(@RequestBody @Valid @NotNull FormEstado formEstado){
        Estado estado = formEstado.toModel(repositoryPais);
        repositoryEstado.save(estado);
        return ResponseEntity.ok().body(estado);
    }
}
