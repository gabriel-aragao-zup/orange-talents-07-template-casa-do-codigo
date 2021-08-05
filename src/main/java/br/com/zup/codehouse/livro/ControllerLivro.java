package br.com.zup.codehouse.livro;

import br.com.zup.codehouse.autor.RepositoryAutor;
import br.com.zup.codehouse.categoria.RepositoryCategoria;
import br.com.zup.codehouse.shared.config.validation.beanvalidation.existsid.ExistsId;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
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
    public ResponseEntity<DTOLivroResumo> createLivro(@RequestBody @Valid @NotNull FormLivro formLivro){
        Livro livro = formLivro.toModel(this.repositoryAutor, this.repositoryCategoria);
        repositoryLivro.save(livro);
        DTOLivroResumo dtoLivro = DTOLivroResumo.from(livro);
        return ResponseEntity.ok().body(dtoLivro);
    }

    @GetMapping
    public ResponseEntity<List<DTOLivroResumo>> getAll(){
        List<Livro> livros = repositoryLivro.findAll();
        List<DTOLivroResumo> dtoLivros = livros.stream().map(DTOLivroResumo::from).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoLivros);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DTOLivroDetalhe> getLivroById(@PathVariable Long id){
        Optional<Livro> livro = repositoryLivro.findById(id);
        if(livro.isPresent()){
            DTOLivroDetalhe dtoLivroDetalhe = DTOLivroDetalhe.from(livro.get());
            return ResponseEntity.ok().body(dtoLivroDetalhe);
        }
        return ResponseEntity.notFound().build();
    }
}
