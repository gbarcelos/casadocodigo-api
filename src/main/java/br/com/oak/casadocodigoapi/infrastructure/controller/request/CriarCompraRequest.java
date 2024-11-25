package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.compra.CompraInput;
import br.com.oak.casadocodigoapi.domain.Cupom;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;
import br.com.oak.casadocodigoapi.infrastructure.annotation.ExistsValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarCompraRequest(
    @NotBlank
    String nome,

    @NotBlank
    String sobreNome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    String cpfCnpj,

    @NotBlank
    String telefone,

    @NotBlank
    String cep,

    @NotBlank
    String endereco,

    @NotBlank
    String complemento,

    @NotBlank
    String cidade,

    @ExistsValue(domainClass = Estado.class)
    Long estadoId,

    @NotNull
    @ExistsValue(domainClass = Pais.class)
    Long paisId,

    @Valid
    @NotNull
    CriarPedidoRequest pedido,

    @ExistsValue(domainClass = Cupom.class, fieldName = "codigo")
    String codigoCupom
) implements CompraInput {

}
