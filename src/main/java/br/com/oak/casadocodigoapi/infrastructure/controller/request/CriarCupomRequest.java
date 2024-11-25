package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.cupom.CupomInput;
import br.com.oak.casadocodigoapi.infrastructure.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.domain.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarCupomRequest(
    @NotBlank
    @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
    String codigo,

    @NotNull
    @Positive
    BigDecimal percentual,

    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dataValidade
) implements CupomInput {
}
