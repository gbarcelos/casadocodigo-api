package br.com.oak.casadocodigoapi.infrastructure.validator;

import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarCompraRequest;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EstadoPertenceAoPaisValidator implements Validator {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public boolean supports(Class<?> clazz) {
    return CriarCompraRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    if (errors.hasErrors()) {
      return;
    }
    CriarCompraRequest request = (CriarCompraRequest) target;

    if (request.estadoId() == null) {
      return;
    }

    Pais pais = entityManager.find(Pais.class, request.paisId());
    Estado estado = entityManager.find(Estado.class, request.estadoId());

    if (!estado.pertenceAoPais(pais)) {
      errors.rejectValue("estadoId", "EstadoPertenceAoPais.criarCompraRequest.estadoId");
    }
  }
}
