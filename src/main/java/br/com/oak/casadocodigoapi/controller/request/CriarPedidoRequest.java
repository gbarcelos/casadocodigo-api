package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.model.Compra;
import br.com.oak.casadocodigoapi.model.ItemPedido;
import br.com.oak.casadocodigoapi.model.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.util.Assert;

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

  public Function<Compra, Pedido> toModel() {
    Set<ItemPedido> itensModel = itens.stream().map(CriarItensPedidoRequest::toModel).collect(
        Collectors.toSet());
    return (compra) -> {
      Pedido pedido = new Pedido(compra, itensModel);
      Assert.isTrue(pedido.totalIgual(total),"O total("+total+") enviado não corresponde ao total real("+pedido.total()+"). Itens = "+ itensModel);
      return pedido;
    };
  }
}
