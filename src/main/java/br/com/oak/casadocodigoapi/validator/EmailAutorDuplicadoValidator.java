package br.com.oak.casadocodigoapi.validator;

import br.com.oak.casadocodigoapi.controller.request.CriarAutorRequest;
import br.com.oak.casadocodigoapi.model.Autor;
import br.com.oak.casadocodigoapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailAutorDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CriarAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        CriarAutorRequest criarAutorRequest = (CriarAutorRequest) target;

       Optional<Autor> autor =  autorRepository.findByEmail(criarAutorRequest.getEmail());
       if (autor.isPresent()){
           errors.rejectValue("email", "criarAutorRequest.email");
       }
    }
}
