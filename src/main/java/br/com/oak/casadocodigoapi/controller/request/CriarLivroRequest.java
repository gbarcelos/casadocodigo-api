package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.model.Autor;
import br.com.oak.casadocodigoapi.model.Categoria;
import br.com.oak.casadocodigoapi.model.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CriarLivroRequest {

  @NotBlank
  @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
  private String titulo;
  @NotBlank
  @Size(min = 1, max = 500)
  private String resumo;
  @NotBlank
  private String sumario;
  @NotNull
  @DecimalMin(value = "20.0")
  @Digits(integer = 3, fraction = 2)
  private BigDecimal preco;
  @NotNull
  @Min(value = 100)
  private Integer numeroDePaginas;
  @NotBlank
  @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
  private String isbn;
  @NotNull
  @Future
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate dataPublicacao;
  @NotNull
  @ExistsValue(domainClass = Categoria.class)
  private Long categoriaId;
  @NotNull
  @ExistsValue(domainClass = Autor.class)
  private Long autorId;

  public CriarLivroRequest(String titulo, String resumo, String sumario, BigDecimal preco,
      Integer numeroDePaginas, String isbn, LocalDate dataPublicacao, Long categoriaId,
      Long autorId) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroDePaginas = numeroDePaginas;
    this.isbn = isbn;
    this.dataPublicacao = dataPublicacao;
    this.categoriaId = categoriaId;
    this.autorId = autorId;
  }

  public Livro toModel() {
    return new Livro(titulo,
        resumo,
        sumario,
        preco,
        numeroDePaginas,
        isbn,
        dataPublicacao,
        new Categoria(categoriaId),
        new Autor(autorId));
  }
}
