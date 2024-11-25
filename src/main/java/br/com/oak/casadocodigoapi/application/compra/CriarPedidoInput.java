package br.com.oak.casadocodigoapi.application.compra;

import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.domain.ItemPedido;
import br.com.oak.casadocodigoapi.domain.Pedido;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarItensPedidoRequest;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface CriarPedidoInput {

  Integer total();

  List<CriarItensPedidoRequest> itens();

  default Integer getTotal() {
    return total();
  }

  default List<CriarItensPedidoRequest> getItens() {
    return itens();
  }

  default Function<Compra, Pedido> toModel(EntityManager entityManager) {
    Set<ItemPedido> itensModel = itens().stream().map(item -> item.toModel(entityManager)).collect(
        Collectors.toSet());
    return (compra) -> new Pedido(compra, itensModel);
  }
}
