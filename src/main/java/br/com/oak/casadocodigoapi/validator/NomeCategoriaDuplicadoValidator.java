package br.com.oak.casadocodigoapi.validator;

import br.com.oak.casadocodigoapi.controller.request.CriarCategoriaRequest;
import br.com.oak.casadocodigoapi.model.Categoria;
import br.com.oak.casadocodigoapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeCategoriaDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return CriarCategoriaRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }
        CriarCategoriaRequest criarCategoriaRequest = (CriarCategoriaRequest) target;

        Optional<Categoria> categoria =  repository.findByNome(criarCategoriaRequest.getNome());
        if (categoria.isPresent()){
            errors.rejectValue("nome", "criarCategoriaRequest.nome");
        }
    }
}
