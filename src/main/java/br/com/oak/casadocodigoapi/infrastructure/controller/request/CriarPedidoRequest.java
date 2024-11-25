package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.compra.CriarPedidoInput;
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

public record CriarPedidoRequest(
    @NotNull
    @Positive
    Integer total,

    @Valid
    @NotNull
    @Size(min = 1)
    List<CriarItensPedidoRequest> itens
) implements CriarPedidoInput {
}
