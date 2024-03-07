package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.model.Estado;
import br.com.oak.casadocodigoapi.model.Pais;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CriarEstadoRequest {
  @NotBlank
  @UniqueValue(domainClass = Estado.class, fieldName = "nome")
  private String nome;
  @NotNull
  private Long paisId;

  public CriarEstadoRequest(String nome, Long paisId) {
    this.nome = nome;
    this.paisId = paisId;
  }

  public Estado toModel() {
    return new Estado(nome, new Pais(paisId));
  }
}
