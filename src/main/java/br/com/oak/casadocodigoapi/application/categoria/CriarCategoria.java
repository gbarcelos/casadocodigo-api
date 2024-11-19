package br.com.oak.casadocodigoapi.application.categoria;


import br.com.oak.casadocodigoapi.domain.Categoria;
import br.com.oak.casadocodigoapi.infrastructure.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CriarCategoria {

  private CategoriaRepository repository; //1

  public CriarCategoria(CategoriaRepository repository) {
    this.repository = repository;
  }

  @Transactional
  public Categoria execute(@Valid CategoriaInput categoriaInput) { //1
    Categoria categoria = new Categoria(categoriaInput.getNome()); //1
    return repository.save(categoria);
  }
}
