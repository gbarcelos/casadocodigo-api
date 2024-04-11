package br.com.oak.casadocodigoapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Cupom {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  private String codigo;

  @NotNull
  @Positive
  private BigDecimal percentualDesconto;

  @NotNull
  @Future
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dataValidade;

  @Deprecated
  public Cupom() {
  }

  public Cupom(String codigo, BigDecimal percentualDesconto, LocalDate dataValidade) {
    this.codigo = codigo;
    this.percentualDesconto = percentualDesconto;
    this.dataValidade = dataValidade;
  }

  public boolean isValido() {
    return LocalDate.now().compareTo(this.dataValidade) <= 0;
  }

  public BigDecimal getPercentualDesconto() {
    return percentualDesconto;
  }

  public LocalDate getDataValidade() {
    return dataValidade;
  }

  @Override
  public String toString() {
    return "Cupom{" +
        "id=" + id +
        ", codigo='" + codigo + '\'' +
        ", percentualDesconto=" + percentualDesconto +
        ", dataValidade=" + dataValidade +
        '}';
  }
}
