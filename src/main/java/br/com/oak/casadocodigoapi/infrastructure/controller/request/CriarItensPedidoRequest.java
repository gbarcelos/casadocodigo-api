package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.infrastructure.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.domain.ItemPedido;
import br.com.oak.casadocodigoapi.domain.Livro;
import jakarta.persistence.EntityManager;
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

  public ItemPedido toModel(EntityManager entityManager) {
    Livro livro = entityManager.find(Livro.class, livroId);
    return new ItemPedido(livro, quantidade);
  }
}
