package br.com.oak.casadocodigoapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Autor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  @Size(min = 1, max = 400)
  private String descricao;
  private LocalDateTime dataHoraCriacao = LocalDateTime.now();

  @Deprecated
  public Autor() {
  }

  public Autor(Long id) {
    this.id = id;
  }

  public Autor(@NotBlank String nome, @NotBlank
  @Email String email, @NotBlank
  @Size(min = 1, max = 400) String descricao) {
    this.nome = nome;
    this.email = email;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  @Override
  public String toString() {
    return "Autor{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        '}';
  }
}
