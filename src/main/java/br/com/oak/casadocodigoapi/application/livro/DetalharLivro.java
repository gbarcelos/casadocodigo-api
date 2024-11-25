package br.com.oak.casadocodigoapi.application.livro;

import br.com.oak.casadocodigoapi.application.BuscadorDeEntidades;
import br.com.oak.casadocodigoapi.domain.Livro;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DetalharLivro {

  private final BuscadorDeEntidades buscadorDeEntidades;

  public DetalharLivro(BuscadorDeEntidades buscadorDeEntidades){
    this.buscadorDeEntidades = buscadorDeEntidades;
  }

  public Optional<Livro> execute(Long id){
    return buscadorDeEntidades.buscaPorId(Livro.class, id);
  }

}
