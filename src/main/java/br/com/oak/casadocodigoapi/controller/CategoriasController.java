package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarCategoriaRequest;
import br.com.oak.casadocodigoapi.model.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> criarCategoria(@RequestBody @Valid CriarCategoriaRequest criarCategoriaRequest) {
        entityManager.persist(new Categoria(criarCategoriaRequest.getNome()));
        return ResponseEntity.ok().build();
    }
}
