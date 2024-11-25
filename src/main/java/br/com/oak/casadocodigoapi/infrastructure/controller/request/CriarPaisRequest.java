package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.pais.PaisInput;
import br.com.oak.casadocodigoapi.domain.Pais;
import jakarta.validation.constraints.NotBlank;

public record CriarPaisRequest(
    @NotBlank
    String nome,
    String codigoIdentificadorPais
) implements PaisInput {
}
