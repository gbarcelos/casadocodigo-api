package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.categoria.CategoriaInput;
import br.com.oak.casadocodigoapi.infrastructure.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.domain.Categoria;
import jakarta.validation.constraints.NotBlank;

public class CriarCategoriaRequest implements CategoriaInput {

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
