package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.application.estado.CriarEstado;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarEstadoRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarEstadoController {

  private final CriarEstado criarEstado;

  public CriarEstadoController(CriarEstado criarEstado) {
    this.criarEstado = criarEstado;
  }

  @PostMapping(value = "/estados")
  public ResponseEntity<Object> criarEstado(
      @RequestBody @Valid CriarEstadoRequest criarEstadoRequest) {
    Estado estado = criarEstado.execute(criarEstadoRequest);
    return ResponseEntity.ok(estado.toString());
  }
}
