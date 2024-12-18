package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarAutorRequest;
import br.com.oak.casadocodigoapi.domain.Autor;
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
@RequestMapping("/autores")
public class AutoresController {

  @PersistenceContext
  private EntityManager entityManager;

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarAutor(
      @RequestBody @Valid CriarAutorRequest criarAutorRequest) {
    Autor autor = criarAutorRequest.toModel();
    entityManager.persist(autor);
    return ResponseEntity.ok(autor.toString());
  }
}
