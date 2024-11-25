package br.com.oak.casadocodigoapi.infrastructure.repository;

import br.com.oak.casadocodigoapi.domain.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CupomRepository extends JpaRepository<Cupom, Long> {

  Cupom findByCodigo(String codigoCupom);
}
