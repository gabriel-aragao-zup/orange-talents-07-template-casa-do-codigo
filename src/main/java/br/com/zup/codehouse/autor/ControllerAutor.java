package br.com.zup.codehouse.autor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/autores")
public class ControllerAutor {

    private RepositoryAutor repositoryAutor;
    private UniqueEmailValidator emailValidator;

    public ControllerAutor(RepositoryAutor repositoryAutor, UniqueEmailValidator emailValidator){
        this.repositoryAutor = repositoryAutor;
        this.emailValidator = emailValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(emailValidator);
    }

    @PostMapping
    public ResponseEntity<DTOAutor> createAutor(@RequestBody @Valid FormAutor formAutor){
        Autor autor = formAutor.toModel();
        repositoryAutor.save(autor);
        DTOAutor dtoAutor = autor.toDTO();
        return ResponseEntity.ok().body(dtoAutor);
    }
}
