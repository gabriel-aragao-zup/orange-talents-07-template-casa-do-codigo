package br.com.zup.codehouse.pais;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class ControllerPais {

    private RepositoryPais repositoryPais;

    public ControllerPais(RepositoryPais repositoryPais) {
        this.repositoryPais = repositoryPais;
    }

    @PostMapping
    public ResponseEntity<Pais> createPais(@RequestBody @Valid FormPais formPais){
        Pais pais = formPais.toModel();
        repositoryPais.save(pais);
        return ResponseEntity.ok().body(pais);
    }
}
