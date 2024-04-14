package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
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
import org.springframework.util.Assert;

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

  @OneToOne(mappedBy = "compra", cascade = CascadeType.PERSIST)
  private Pedido pedido;

  @Embedded
  private CupomAplicado cupomAplicado;

  @Deprecated
  public Compra() {
  }

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobreNome() {
    return sobreNome;
  }

  public void setSobreNome(String sobreNome) {
    this.sobreNome = sobreNome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public void setCpfCnpj(String cpfCnpj) {
    this.cpfCnpj = cpfCnpj;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public Pais getPais() {
    return pais;
  }

  public void setPais(Pais pais) {
    this.pais = pais;
  }

  public Estado getEstado() {
    return estado;
  }

  public Pedido getPedido() {
    return pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public CupomAplicado getCupomAplicado() {
    return cupomAplicado;
  }

  public void setCupomAplicado(CupomAplicado cupomAplicado) {
    this.cupomAplicado = cupomAplicado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public void aplicaCupom(Cupom cupom) {
    Assert.isTrue(cupom.isValido(), "Cupom sendo aplicado não está válido");
    Assert.isNull(this.cupomAplicado, "Não é possível alterar o cupom de uma compra");
    this.cupomAplicado = new CupomAplicado(cupom);
  }

  @Override
  public String toString() {
    return "Compra{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", sobreNome='" + sobreNome + '\'' +
        ", email='" + email + '\'' +
        ", cpfCnpj='" + cpfCnpj + '\'' +
        ", telefone='" + telefone + '\'' +
        ", cep='" + cep + '\'' +
        ", endereco='" + endereco + '\'' +
        ", complemento='" + complemento + '\'' +
        ", cidade='" + cidade + '\'' +
        ", pais=" + pais +
        ", estado=" + estado +
        ", pedido=" + pedido +
        ", cupomAplicado=" + cupomAplicado +
        '}';
  }
}
