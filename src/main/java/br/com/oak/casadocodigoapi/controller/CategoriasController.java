package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarCategoriaRequest;
import br.com.oak.casadocodigoapi.model.Categoria;
import br.com.oak.casadocodigoapi.repository.CategoriaRepository;
import br.com.oak.casadocodigoapi.validator.NomeCategoriaDuplicadoValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private CategoriaRepository repository;

    @Autowired
    private NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(nomeCategoriaDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CriarCategoriaRequest criarCategoriaRequest) {
        repository.save(new Categoria(criarCategoriaRequest.getNome()));
        return ResponseEntity.ok().build();
    }
}
