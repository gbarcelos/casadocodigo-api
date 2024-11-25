package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.estado.EstadoInput;
import br.com.oak.casadocodigoapi.infrastructure.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.infrastructure.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CriarEstadoRequest(
    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    String nome,

    @NotNull
    @ExistsValue(domainClass = Pais.class)
    Long paisId
) implements EstadoInput {
}
