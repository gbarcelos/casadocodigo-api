package br.com.oak.casadocodigoapi.repository;

import br.com.oak.casadocodigoapi.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
