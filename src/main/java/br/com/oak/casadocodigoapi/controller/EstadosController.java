package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarEstadoRequest;
import br.com.oak.casadocodigoapi.model.Estado;
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
@RequestMapping("/estados")
public class EstadosController {
  @PersistenceContext
  private EntityManager entityManager;

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarEstado(
      @RequestBody @Valid CriarEstadoRequest criarEstadoRequest) {
    Estado estado = criarEstadoRequest.toModel();
    entityManager.persist(estado);
    return ResponseEntity.ok(estado.toString());
  }
}
