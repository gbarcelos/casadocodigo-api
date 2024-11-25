package br.com.oak.casadocodigoapi.application.compra;

import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.infrastructure.repository.CompraRepository;
import br.com.oak.casadocodigoapi.infrastructure.repository.CupomRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CriarCompra {

  private final EntityManager entityManager;
  private CupomRepository cupomRepository;
  private final CompraRepository compraRepository;

  public CriarCompra(EntityManager entityManager, CupomRepository cupomRepository,
      CompraRepository compraRepository) {
    this.entityManager = entityManager;
    this.cupomRepository = cupomRepository;
    this.compraRepository = compraRepository;
  }

  @Transactional
  public Compra execute(@Valid CompraInput compraInput) {
    Compra compra = compraInput.toModel(entityManager, cupomRepository);
    return compraRepository.save(compra);
  }
}
