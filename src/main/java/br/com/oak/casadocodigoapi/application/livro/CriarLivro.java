package br.com.oak.casadocodigoapi.application.livro;

import br.com.oak.casadocodigoapi.domain.Livro;
import br.com.oak.casadocodigoapi.infrastructure.repository.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CriarLivro {

  private LivroRepository repository;

  public CriarLivro(LivroRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Livro execute(@Valid LivroInput input) {
    return repository.save(input.toModel());
  }
}
