package br.com.oak.casadocodigoapi.infrastructure.repository;

import br.com.oak.casadocodigoapi.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
