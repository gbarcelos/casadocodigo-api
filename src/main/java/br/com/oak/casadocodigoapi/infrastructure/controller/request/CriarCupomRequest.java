package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.infrastructure.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.domain.Cupom;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CriarCupomRequest {

  @NotBlank
  @UniqueValue(domainClass = Cupom.class, fieldName = "codigo")
  private String codigo;

  @NotNull
  @Positive
  private BigDecimal percentual;

  @NotNull
  @Future
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dataValidade;

  public CriarCupomRequest(String codigo, BigDecimal percentual, LocalDate dataValidade) {
    this.codigo = codigo;
    this.percentual = percentual;
    this.dataValidade = dataValidade;
  }

  public Cupom toModel() {
    return new Cupom(codigo, percentual, dataValidade);
  }
}
