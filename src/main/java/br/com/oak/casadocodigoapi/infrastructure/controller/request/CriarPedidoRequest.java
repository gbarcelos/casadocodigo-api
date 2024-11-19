package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.domain.ItemPedido;
import br.com.oak.casadocodigoapi.domain.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CriarPedidoRequest {

  @NotNull
  @Positive
  private Integer total;

  @Valid
  @NotNull
  @Size(min = 1)
  private List<CriarItensPedidoRequest> itens = new ArrayList<>();

  public CriarPedidoRequest(Integer total, List<CriarItensPedidoRequest> itens) {
    this.total = total;
    this.itens = itens;
  }

  public Integer getTotal() {
    return total;
  }

  public List<CriarItensPedidoRequest> getItens() {
    return itens;
  }

  public Function<Compra, Pedido> toModel(EntityManager entityManager) {
    Set<ItemPedido> itensModel = itens.stream().map(item -> item.toModel(entityManager)).collect(
        Collectors.toSet());
    return (compra) -> {
      return new Pedido(compra, itensModel);
    };
  }
}
