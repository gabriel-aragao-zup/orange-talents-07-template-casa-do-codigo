package br.com.zup.codehouse.cliente;

import br.com.zup.codehouse.estado.Estado;
import br.com.zup.codehouse.estado.RepositoryEstado;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Optional;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    private RepositoryEstado repositoryEstado;

    public EstadoPertenceAPaisValidator(RepositoryEstado repositoryEstado) {
        this.repositoryEstado = repositoryEstado;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FormCliente.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        FormCliente formCliente = (FormCliente) o;
        List<Estado> estadosNoPais = repositoryEstado.findByPais_Id(formCliente.getPaisId());

        if(formCliente.getEstadoId() == null && !estadosNoPais.isEmpty()){
            errors.rejectValue("estadoId", null, null, "Um Estado precisa ser selecionado para o país informado.");
        }else if(formCliente.getEstadoId() != null && estadosNoPais.isEmpty()){
            errors.rejectValue("estadoId", null, null, "Não existem estados para o país informado.");
        }else if (formCliente.getEstadoId() != null && !estadosNoPais.isEmpty()){
            Estado estado = repositoryEstado.getById(formCliente.getEstadoId());
            if(estado.getPais().getId() != formCliente.getPaisId()){
                errors.rejectValue("estadoId", null, null, "O estado informado Não pertence ao país informado.");
            }
        }
    }
}
