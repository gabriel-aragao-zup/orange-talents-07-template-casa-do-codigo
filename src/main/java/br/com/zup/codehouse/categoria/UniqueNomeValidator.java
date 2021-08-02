package br.com.zup.codehouse.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueNomeValidator implements Validator {

    @Autowired
    RepositoryCategoria repositoryCategoria;

    @Override
    public boolean supports(Class<?> aClass) {
        return FormCategoria.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        FormCategoria formCategoria = (FormCategoria) o;
        Optional<Categoria> possivelCategoria = repositoryCategoria.findByNome(formCategoria.getNome());
        if(possivelCategoria.isPresent()){
            errors.rejectValue("nome", null, "categoria já cadastrada");
        }
    }
}
