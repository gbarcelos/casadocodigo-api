package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.infrastructure.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.infrastructure.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CriarEstadoRequest {
  @NotBlank
  @UniqueValue(domainClass = Estado.class, fieldName = "nome")
  private String nome;
  @NotNull
  @ExistsValue(domainClass = Pais.class)
  private Long paisId;

  public CriarEstadoRequest(String nome, Long paisId) {
    this.nome = nome;
    this.paisId = paisId;
  }

  public Estado toModel() {
    return new Estado(nome, new Pais(paisId));
  }
}
