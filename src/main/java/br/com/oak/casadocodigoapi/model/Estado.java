package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Table(name = "estados")
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

  public Estado(String nome, Pais pais) {
    this.nome = nome;
    this.pais = pais;
  }
}
