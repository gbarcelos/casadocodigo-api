package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarLivroRequest;
import br.com.oak.casadocodigoapi.controller.response.DetalharLivroResponse;
import br.com.oak.casadocodigoapi.controller.response.ListarLivrosResponse;
import br.com.oak.casadocodigoapi.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/livros")
public class LivrosController {

  @PersistenceContext
  private EntityManager entityManager;

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarLivro(
      @RequestBody @Valid CriarLivroRequest criarLivroRequest) {
    entityManager.persist(criarLivroRequest.toModel());
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<ListarLivrosResponse>> listarLivros() {
    Query queryLivros = entityManager.createQuery("select l from Livro l");

    List<Livro> resultList = queryLivros.getResultList();

    List<ListarLivrosResponse> listarLivrosResponse = resultList.stream()
        .map(ListarLivrosResponse::new)
        .toList();

    return ResponseEntity.ok(listarLivrosResponse);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DetalharLivroResponse> detalharLivro(@PathVariable Long id) {

    Livro livro = entityManager.find(Livro.class, id);

    if (livro == null){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado");
    }

    return ResponseEntity.ok(new DetalharLivroResponse(livro));
  }
}
