package br.com.oak.casadocodigoapi.controller.response;

import br.com.oak.casadocodigoapi.model.Compra;

public class CompraResponse {

  private Long id;

  private String nome;

  private String sobreNome;


  private String email;

  private String cpfCnpj;

  private String telefone;

  private String cep;

  private String endereco;

  private String complemento;

  private String cidade;

  private String possuiCupom;

  private String valorDaCompra;

  public CompraResponse(Compra compra) {
    this.id = compra.getId();
    this.nome = compra.getNome();
    this.sobreNome = compra.getSobreNome();
    this.email = compra.getEmail();
    this.cpfCnpj = compra.getCpfCnpj();
    this.telefone = compra.getTelefone();
    this.cep = compra.getCep();
    this.endereco = compra.getEndereco();
    this.complemento = compra.getComplemento();
    this.cidade = compra.getCidade();
    this.possuiCupom = compra.getCupomAplicado() != null ? "Sim": "Não";
    this.valorDaCompra = compra.getPedido().totalCompra().toString();
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public String getSobreNome() {
    return sobreNome;
  }

  public String getEmail() {
    return email;
  }

  public String getCpfCnpj() {
    return cpfCnpj;
  }

  public String getTelefone() {
    return telefone;
  }

  public String getCep() {
    return cep;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getComplemento() {
    return complemento;
  }

  public String getCidade() {
    return cidade;
  }

  public String getPossuiCupom() {
    return possuiCupom;
  }

  public String getValorDaCompra() {
    return valorDaCompra;
  }
}
