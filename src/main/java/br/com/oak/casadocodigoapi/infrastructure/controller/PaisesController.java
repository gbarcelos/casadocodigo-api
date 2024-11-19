package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarPaisRequest;
import br.com.oak.casadocodigoapi.domain.Pais;
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
@RequestMapping("/paises")
public class PaisesController {

  @PersistenceContext
  private EntityManager entityManager;

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarPais(
      @RequestBody @Valid CriarPaisRequest criarPaisRequest) {
    Pais pais = criarPaisRequest.toModel();
    entityManager.persist(pais);
    return ResponseEntity.ok(pais.toString());
  }
}
