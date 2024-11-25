package br.com.oak.casadocodigoapi.application.cupom;

import br.com.oak.casadocodigoapi.domain.Cupom;
import br.com.oak.casadocodigoapi.infrastructure.repository.CupomRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CriarCupom {

  private final CupomRepository cupomRepository;

  public CriarCupom(CupomRepository cupomRepository) {
    this.cupomRepository = cupomRepository;
  }

  @Transactional
  public Cupom execute(@Valid CupomInput cupomInput) {
    return cupomRepository.save(cupomInput.toModel());
  }
}
