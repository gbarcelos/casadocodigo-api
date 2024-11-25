package br.com.oak.casadocodigoapi.application;

import java.util.Optional;
public interface BuscadorDeEntidades {
  <T> T retornaPorId(Class<T> clazz, Long id);

  <T> Optional<T> buscaPorId(Class<T> clazz, Long id);
}
