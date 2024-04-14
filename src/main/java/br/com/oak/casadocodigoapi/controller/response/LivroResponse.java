package br.com.oak.casadocodigoapi.controller.response;

import br.com.oak.casadocodigoapi.model.Livro;

public class LivroResponse {

  private Long id;
  private String titulo;
  private String resumo;
  private String preco;
  private Integer numeroDePaginas;
  private String isbn;
  private String categoria;
  private String autor;


  public LivroResponse(Livro livro) {
    this.id = livro.getId();
    this.titulo= livro.getTitulo();
    this.resumo = livro.getResumo();
    this.preco = livro.getPreco().toString();
    this.numeroDePaginas = livro.getNumeroDePaginas();
    this.isbn = livro.getIsbn();
    this.categoria = livro.getCategoria().getNome();
    this.autor = livro.getAutor().getNome();
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }

  public String getResumo() {
    return resumo;
  }

  public String getPreco() {
    return preco;
  }

  public Integer getNumeroDePaginas() {
    return numeroDePaginas;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getCategoria() {
    return categoria;
  }

  public String getAutor() {
    return autor;
  }
}
