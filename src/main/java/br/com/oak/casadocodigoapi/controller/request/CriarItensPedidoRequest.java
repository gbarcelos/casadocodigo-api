package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.model.ItemPedido;
import br.com.oak.casadocodigoapi.model.Livro;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CriarItensPedidoRequest {

  @NotNull
  @ExistsValue(domainClass = Livro.class)
  private Long livroId;

  @NotNull
  @Positive
  private Integer quantidade;

  public CriarItensPedidoRequest(Long livroId, Integer quantidade) {
    this.livroId = livroId;
    this.quantidade = quantidade;
  }

  public Long getLivroId() {
    return livroId;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public ItemPedido toModel() {
    return new ItemPedido(new Livro(livroId), quantidade);
  }
}
