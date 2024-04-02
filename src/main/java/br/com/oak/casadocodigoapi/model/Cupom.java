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
  private BigDecimal percentual;

  @NotNull
  @Future
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dataValidade;

  public Cupom(String codigo, BigDecimal percentual, LocalDate dataValidade) {
    this.codigo = codigo;
    this.percentual = percentual;
    this.dataValidade = dataValidade;
  }
}
