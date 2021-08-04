package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.RepositoryAutor;
import br.com.zup.codehouse.categoria.RepositoryCategoria;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class ControllerLivro {

    private RepositoryLivro repositoryLivro;
    private RepositoryAutor repositoryAutor;
    private RepositoryCategoria repositoryCategoria;

    public ControllerLivro(RepositoryLivro repositoryLivro, RepositoryAutor repositoryAutor,
                           RepositoryCategoria repositoryCategoria) {
        this.repositoryLivro = repositoryLivro;
        this.repositoryAutor = repositoryAutor;
        this.repositoryCategoria = repositoryCategoria;
    }

    @PostMapping
    public ResponseEntity<DTOLivro> createLivro(@RequestBody @Valid @NotNull FormLivro formLivro){
        Livro livro = formLivro.toModel(this.repositoryAutor, this.repositoryCategoria);
        repositoryLivro.save(livro);
        DTOLivro dtoLivro = livro.toDTO();
        return ResponseEntity.ok().body(dtoLivro);
    }

    @GetMapping
    public ResponseEntity<List<DTOLivro>> getAll(){
        List<Livro> livros = repositoryLivro.findAll();
        List<DTOLivro> dtoLivros = livros.stream().map(Livro::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoLivros);
    }
}
