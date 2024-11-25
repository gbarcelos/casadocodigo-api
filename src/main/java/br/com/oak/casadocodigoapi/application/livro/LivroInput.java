package br.com.oak.casadocodigoapi.application.livro;

import br.com.oak.casadocodigoapi.domain.Autor;
import br.com.oak.casadocodigoapi.domain.Categoria;
import br.com.oak.casadocodigoapi.domain.Livro;
import java.math.BigDecimal;
import java.time.LocalDate;

public interface LivroInput {

  String titulo();

  String resumo();

  String sumario();

  BigDecimal preco();

  Integer numeroDePaginas();

  String isbn();

  LocalDate dataPublicacao();

  Long categoriaId();

  Long autorId();

  default Livro toModel() {
    return new Livro(titulo(),
        resumo(),
        sumario(),
        preco(),
        numeroDePaginas(),
        isbn(),
        dataPublicacao(),
        new Categoria(categoriaId()),
        new Autor(autorId()));
  }
}
