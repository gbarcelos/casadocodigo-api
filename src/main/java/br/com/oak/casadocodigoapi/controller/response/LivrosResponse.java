package br.com.oak.casadocodigoapi.controller.response;

import br.com.oak.casadocodigoapi.model.Livro;

public class LivrosResponse {

  private Long id;
  private String titulo;

  public LivrosResponse(Livro livro) {
    this.id = livro.getId();
    this.titulo = livro.getTitulo();
  }

  public Long getId() {
    return id;
  }

  public String getTitulo() {
    return titulo;
  }
}
