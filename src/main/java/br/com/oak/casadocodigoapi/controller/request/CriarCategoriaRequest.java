package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.model.Categoria;
import jakarta.validation.constraints.NotBlank;

public class CriarCategoriaRequest {

  @NotBlank
  @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
  private String nome;

  @Deprecated
  public CriarCategoriaRequest() {
  }

  public CriarCategoriaRequest(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }
}
