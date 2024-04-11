package br.com.oak.casadocodigoapi.repository;

import br.com.oak.casadocodigoapi.model.Cupom;
import org.springframework.data.repository.Repository;


public interface CupomRepository extends Repository<Cupom, Long> {

  Cupom findByCodigo(String codigoCupom);
}
