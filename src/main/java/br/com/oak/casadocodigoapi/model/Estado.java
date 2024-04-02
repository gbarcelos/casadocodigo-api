package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Estado {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "pais_id", nullable = false)
  private Pais pais;

  @Deprecated
  public Estado() {
  }

  public Estado(Long id) {
    this.id = id;
  }

  public Estado(String nome, Pais pais) {
    this.nome = nome;
    this.pais = pais;
  }

  public boolean pertenceAoPais(Pais pais) {
    return this.pais.equals(pais);
  }
}
