package br.com.oak.casadocodigoapi.application.cupom;

import br.com.oak.casadocodigoapi.domain.Cupom;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface CupomInput {

  String codigo();
  BigDecimal percentual();
  LocalDate dataValidade();

  default Cupom toModel() {
    return new Cupom(codigo(), percentual(), dataValidade());
  }
}
