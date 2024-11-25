package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.application.pais.CriarPais;
import br.com.oak.casadocodigoapi.domain.Pais;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarPaisRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarPaisController {

  private final CriarPais criarPais;

  public CriarPaisController(CriarPais criarPais) {
    this.criarPais = criarPais;
  }

  @PostMapping(value = "/paises")
  public ResponseEntity<Object> criarPais(
      @RequestBody @Valid CriarPaisRequest criarPaisRequest) {
    Pais pais = criarPais.execute(criarPaisRequest);
    return ResponseEntity.ok(pais.toString());
  }
}
