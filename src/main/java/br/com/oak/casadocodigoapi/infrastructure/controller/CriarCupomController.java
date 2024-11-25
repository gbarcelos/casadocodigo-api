package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.application.cupom.CriarCupom;
import br.com.oak.casadocodigoapi.domain.Cupom;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarCupomRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarCupomController {

  private final CriarCupom criarCupom;

  public CriarCupomController(CriarCupom criarCupom) {
    this.criarCupom = criarCupom;
  }

  @PostMapping(value = "/cupons")
  public ResponseEntity<Object> criarCupom(
      @RequestBody @Valid CriarCupomRequest criarCupomRequest) {
    Cupom cupom = criarCupom.execute(criarCupomRequest);
    return ResponseEntity.ok(cupom.toString());
  }
}
