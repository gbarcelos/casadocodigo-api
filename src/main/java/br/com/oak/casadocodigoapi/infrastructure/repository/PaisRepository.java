package br.com.oak.casadocodigoapi.infrastructure.repository;

import br.com.oak.casadocodigoapi.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository  extends JpaRepository<Pais, Long> {

}
