package br.com.zup.codehouse.categoria;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class ControllerCategoria {

    private RepositoryCategoria repositoryCategoria;

    public ControllerCategoria(RepositoryCategoria repositoryCategoria){
        this.repositoryCategoria = repositoryCategoria;
    }



    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody @Valid FormCategoria formCategoria){
        Categoria categoria = formCategoria.toModel();
        repositoryCategoria.save(categoria);
        return ResponseEntity.ok().body(categoria);
    }
}
