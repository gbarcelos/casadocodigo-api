package br.com.oak.casadocodigoapi.application.estado;

import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;

public interface EstadoInput {

  String nome();

  Long paisId();

  default Estado toModel() {
    return new Estado(nome(), new Pais(paisId()));
  }
}
