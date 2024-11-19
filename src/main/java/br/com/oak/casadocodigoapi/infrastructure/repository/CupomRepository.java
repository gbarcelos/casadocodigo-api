package br.com.oak.casadocodigoapi.infrastructure.repository;

import br.com.oak.casadocodigoapi.domain.Cupom;
import org.springframework.data.repository.Repository;


public interface CupomRepository extends Repository<Cupom, Long> {

  Cupom findByCodigo(String codigoCupom);
}
