package br.com.zup.codehouse.autor;

import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class ControllerAutor {

    private RepositoryAutor repositoryAutor;

    public ControllerAutor(RepositoryAutor repositoryAutor){
        this.repositoryAutor = repositoryAutor;
    }

    @PostMapping
    public ResponseEntity<DTOAutor> createAutor(@RequestBody @Valid @NotNull FormAutor formAutor){
        Autor autor = formAutor.toModel();
        repositoryAutor.save(autor);
        DTOAutor dtoAutor = autor.toDTO();
        return ResponseEntity.ok().body(dtoAutor);
    }
}
