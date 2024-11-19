package br.com.oak.casadocodigoapi.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class CupomAplicado {

  @ManyToOne
  private Cupom cupom;

  @NotNull
  @Positive
  private BigDecimal percentualDesconto;

  @NotNull
  @Future
  private LocalDate dataValidade;

  @Deprecated
  public CupomAplicado() {
  }

  public CupomAplicado(Cupom cupom) {
    this.cupom = cupom;
    this.percentualDesconto = cupom.getPercentualDesconto();
    this.dataValidade = cupom.getDataValidade();
  }

  @Override
  public String toString() {
    return "CupomAplicado{" +
        "cupom=" + cupom +
        ", percentualDesconto=" + percentualDesconto +
        ", dataValidade=" + dataValidade +
        '}';
  }
}
