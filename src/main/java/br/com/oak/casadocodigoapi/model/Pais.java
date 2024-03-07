package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table(name = "paises")
@Entity
public class Pais {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  private String codigoIdentificadorPais;

  public Pais(String nome, String codigoIdentificadorPais) {
    this.nome = nome;
    this.codigoIdentificadorPais = codigoIdentificadorPais;
  }

  public Pais(Long id) {
    this.id = id;
  }
}
