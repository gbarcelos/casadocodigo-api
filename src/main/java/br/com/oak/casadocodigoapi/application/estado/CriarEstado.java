package br.com.oak.casadocodigoapi.application.estado;

import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.infrastructure.repository.EstadoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CriarEstado {

  private final EstadoRepository estadoRepository;

  public CriarEstado(EstadoRepository estadoRepository) {
    this.estadoRepository = estadoRepository;
  }

  @Transactional
  public Estado execute(@Valid EstadoInput estadoInput) {
    return estadoRepository.save(estadoInput.toModel());
  }
}
