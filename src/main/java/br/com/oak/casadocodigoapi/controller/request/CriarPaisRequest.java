package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.model.Pais;
import jakarta.validation.constraints.NotBlank;

public class CriarPaisRequest {

  @NotBlank
  private String nome;
  private String codigoIdentificadorPais;

  public CriarPaisRequest(String nome, String codigoIdentificadorPais) {
    this.nome = nome;
    this.codigoIdentificadorPais = codigoIdentificadorPais;
  }

  public Pais toModel() {
    return new Pais(this.nome, this.codigoIdentificadorPais);
  }
}
