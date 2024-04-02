package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.function.Function;

@Entity
public class Compra {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank
  private String nome;
  @NotBlank
  private String sobreNome;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String cpfCnpj;
  @NotBlank
  private String telefone;
  @NotBlank
  private String cep;
  @NotBlank
  private String endereco;
  @NotBlank
  private String complemento;
  @NotBlank
  private String cidade;
  @NotNull
  @ManyToOne
  @JoinColumn(name = "pais_id", nullable = false)
  private Pais pais;

  @ManyToOne
  @JoinColumn(name = "estado_id")
  private Estado estado;

  @OneToOne(mappedBy = "compra",cascade = CascadeType.PERSIST)
  private Pedido pedido;

  public Compra(String nome, String sobreNome, String email, String cpfCnpj,
      String telefone,
      String cep, String endereco, String complemento, String cidade, Pais pais,
      Function<Compra, Pedido> criacaoPedidoFunction) {
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.email = email;
    this.cpfCnpj = cpfCnpj;
    this.telefone = telefone;
    this.cep = cep;
    this.endereco = endereco;
    this.complemento = complemento;
    this.cidade = cidade;
    this.pais = pais;
    this.pedido = criacaoPedidoFunction.apply(this);
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }
}
