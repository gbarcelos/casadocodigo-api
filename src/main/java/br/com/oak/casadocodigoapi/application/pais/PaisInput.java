package br.com.oak.casadocodigoapi.application.pais;

import br.com.oak.casadocodigoapi.domain.Pais;

public interface PaisInput {

  String nome();

  String codigoIdentificadorPais();

  default Pais toModel() {
    return new Pais(nome(), codigoIdentificadorPais());
  }
}
