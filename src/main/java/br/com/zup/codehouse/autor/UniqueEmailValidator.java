package br.com.zup.codehouse.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UniqueEmailValidator implements Validator {

    @Autowired
    RepositoryAutor repositoryAutor;

    @Override
    public boolean supports(Class<?> aClass) {
        return FormAutor.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        FormAutor formAutor = (FormAutor) o;
        Optional<Autor> possivelAutor = repositoryAutor.findByEmail(formAutor.getEmail());
        if(possivelAutor.isPresent()){
            errors.rejectValue("email", null, "email já cadastrado");
        }
    }
}
