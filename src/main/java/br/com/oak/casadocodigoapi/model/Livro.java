package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "livros")
@Entity(name = "Livro")
public class Livro {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String titulo;
  @NotBlank
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
  private String isbn;
  @NotNull
  @Future
  private LocalDate dataPublicacao;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "categoria_id", nullable = false)
  private Categoria categoria;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "autor_id", nullable = false)
  private Autor autor;

  @Deprecated
  public Livro() {
  }

  public Livro(String titulo,
      String resumo,
      String sumario,
      BigDecimal preco,
      Integer numeroDePaginas,
      String isbn,
      LocalDate dataPublicacao,
      Categoria categoria,
      Autor autor) {
    this.titulo = titulo;
    this.resumo = resumo;
    this.sumario = sumario;
    this.preco = preco;
    this.numeroDePaginas = numeroDePaginas;
    this.isbn = isbn;
    this.dataPublicacao = dataPublicacao;
    this.categoria = categoria;
    this.autor = autor;
  }

  public Long getId() {
    return this.id;
  }

  public String getTitulo() {
    return this.titulo;
  }
}
