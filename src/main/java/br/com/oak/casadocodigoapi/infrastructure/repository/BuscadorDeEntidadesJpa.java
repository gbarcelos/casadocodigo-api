package br.com.oak.casadocodigoapi.infrastructure.repository;

import br.com.oak.casadocodigoapi.application.BuscadorDeEntidades;
import jakarta.persistence.EntityManager;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuscadorDeEntidadesJpa implements BuscadorDeEntidades {

  @Autowired
  private EntityManager manager;

  @Override
  public <T> T retornaPorId(Class<T> clazz, Long id) {
    return manager.find(clazz, id);
  }

  @Override
  public <T> Optional<T> buscaPorId(Class<T> clazz, Long id) {
    return Optional.ofNullable(manager.find(clazz, id));
  }
}
