package br.com.oak.casadocodigoapi.infrastructure.validator;

import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarPedidoRequest;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarCompraRequest;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarItensPedidoRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TotalItensCarrinhoValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return CriarCompraRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    if (errors.hasErrors()) {
      return;
    }
    CriarCompraRequest request = (CriarCompraRequest) target;

    CriarPedidoRequest pedido = request.getPedido();
    Integer totalCarrinho = pedido.getTotal();
    Integer totalCalculado = pedido.getItens().stream()
        .map(CriarItensPedidoRequest::getQuantidade)
        .reduce(0, Integer::sum);

    if (totalCarrinho.compareTo(totalCalculado) != 0) {
      errors.rejectValue("carrinho.total", "TotalItensPedido.criarCompraRequest.pedido.total");
    }
  }
}
