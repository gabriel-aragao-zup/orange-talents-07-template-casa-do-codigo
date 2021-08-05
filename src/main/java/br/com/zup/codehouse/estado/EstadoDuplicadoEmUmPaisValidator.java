package br.com.zup.codehouse.estado;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EstadoDuplicadoEmUmPaisValidator implements Validator {


    private RepositoryEstado repositoryEstado;

    public EstadoDuplicadoEmUmPaisValidator(RepositoryEstado repositoryEstado) {
        this.repositoryEstado = repositoryEstado;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FormEstado.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        FormEstado formEstado = (FormEstado) o;
        Optional<Estado> possivelEstado = repositoryEstado.findByNomeAndPais_Id(formEstado.getNome(), formEstado.getPaisId());
        if(possivelEstado.isPresent()){
            errors.rejectValue("nome", null, null, "Já existe um estado com esse nome no país especificado.");
        }

    }
}
