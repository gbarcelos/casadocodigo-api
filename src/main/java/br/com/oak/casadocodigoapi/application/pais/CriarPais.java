package br.com.oak.casadocodigoapi.application.pais;

import br.com.oak.casadocodigoapi.domain.Pais;
import br.com.oak.casadocodigoapi.infrastructure.repository.PaisRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CriarPais {

  private final PaisRepository paisRepository;

  public CriarPais(PaisRepository paisRepository) {
    this.paisRepository = paisRepository;
  }

  @Transactional
  public Pais execute(@Valid PaisInput paisInput) {
    return paisRepository.save(paisInput.toModel());
  }
}
