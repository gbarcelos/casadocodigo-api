package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.application.livro.DetalharLivro;
import br.com.oak.casadocodigoapi.domain.Livro;
import br.com.oak.casadocodigoapi.infrastructure.controller.response.LivroResponse;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DetalharLivroController {

  private final DetalharLivro detalharLivro;

  public DetalharLivroController(DetalharLivro detalharLivro) {
    this.detalharLivro = detalharLivro;
  }

  @GetMapping("/livros/{id}")
  public ResponseEntity<LivroResponse> detalharLivro(@PathVariable Long id) {
    Optional<Livro> livroOptional = detalharLivro.execute(id);
    livroOptional.orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado"));

    return ResponseEntity.ok(new LivroResponse(livroOptional.get()));
  }

}
