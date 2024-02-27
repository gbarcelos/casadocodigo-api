package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarAutorRequest;
import br.com.oak.casadocodigoapi.repository.AutorRepository;
import br.com.oak.casadocodigoapi.validator.EmailAutorDuplicadoValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autores")
public class AutoresController {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EmailAutorDuplicadoValidator emailAutorDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(emailAutorDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> criarAutor(@RequestBody @Valid CriarAutorRequest criarAutorRequest) {
        autorRepository.save(criarAutorRequest.toModel());
        return ResponseEntity.ok().build();
    }
}
