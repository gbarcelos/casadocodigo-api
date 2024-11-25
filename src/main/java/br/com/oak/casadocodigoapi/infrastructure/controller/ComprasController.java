package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.infrastructure.controller.response.CompraResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ComprasController {

  @PersistenceContext
  private EntityManager entityManager;

  @GetMapping("/compras/{id}")
  public ResponseEntity<CompraResponse> detalharCompra(@PathVariable Long id) {

    Compra compra = entityManager.find(Compra.class, id);

    if (compra == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada");
    }

    return ResponseEntity.ok(new CompraResponse(compra));
  }

}
