package br.com.oak.casadocodigoapi.infrastructure.repository;

import br.com.oak.casadocodigoapi.domain.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Long> {

}
