package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.domain.Livro;
import br.com.oak.casadocodigoapi.infrastructure.controller.response.LivrosResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosController {

  @PersistenceContext
  private EntityManager entityManager;

  @GetMapping(value = "/livros")
  public ResponseEntity<List<LivrosResponse>> listarLivros() {
    Query queryLivros = entityManager.createQuery("select l from Livro l");

    List<Livro> resultList = queryLivros.getResultList();

    List<LivrosResponse> listarLivrosResponse = resultList.stream()
        .map(LivrosResponse::new)
        .toList();

    return ResponseEntity.ok(listarLivrosResponse);
  }
}
