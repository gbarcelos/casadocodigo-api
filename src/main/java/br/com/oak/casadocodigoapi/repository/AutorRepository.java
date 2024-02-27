package br.com.oak.casadocodigoapi.repository;

import br.com.oak.casadocodigoapi.model.Autor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AutorRepository extends CrudRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
