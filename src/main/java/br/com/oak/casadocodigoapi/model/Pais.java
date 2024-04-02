package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Pais {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  private String codigoIdentificadorPais;

  @Deprecated
  public Pais() {
  }

  public Pais(String nome, String codigoIdentificadorPais) {
    this.nome = nome;
    this.codigoIdentificadorPais = codigoIdentificadorPais;
  }

  public Pais(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pais pais = (Pais) o;
    return Objects.equals(id, pais.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

