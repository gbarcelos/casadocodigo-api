package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.infrastructure.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.domain.Cupom;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;
import br.com.oak.casadocodigoapi.infrastructure.repository.CupomRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

public class CriarCompraRequest {

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

  @ExistsValue(domainClass = Estado.class)
  private Long estadoId;

  @NotNull
  @ExistsValue(domainClass = Pais.class)
  private Long paisId;

  @Valid
  @NotNull
  private CriarPedidoRequest pedido;

  @ExistsValue(domainClass = Cupom.class, fieldName = "codigo")
  private String codigoCupom;

  public CriarCompraRequest(String nome, String sobreNome, String email, String cpfCnpj,
      String telefone, String cep, String endereco, String complemento, String cidade,
      Long estadoId,
      Long paisId, CriarPedidoRequest pedido) {
    this.nome = nome;
    this.sobreNome = sobreNome;
    this.email = email;
    this.cpfCnpj = cpfCnpj;
    this.telefone = telefone;
    this.cep = cep;
    this.endereco = endereco;
    this.complemento = complemento;
    this.cidade = cidade;
    this.estadoId = estadoId;
    this.paisId = paisId;
    this.pedido = pedido;
  }

  public Compra toModel(EntityManager entityManager, CupomRepository cupomRepository) {

    Compra compra = new Compra(this.nome,
        this.sobreNome,
        this.email,
        this.cpfCnpj,
        this.telefone,
        this.cep,
        this.endereco,
        this.complemento,
        this.cidade,
        new Pais(this.paisId),
        pedido.toModel(entityManager));

    if (estadoId != null) {
      compra.setEstado(new Estado(estadoId));
    }

    if (StringUtils.hasText(codigoCupom)){
      Cupom cupom = cupomRepository.findByCodigo(codigoCupom);
      compra.aplicaCupom(cupom);
    }

    return compra;
  }

  public boolean isCpfOuCnpjValido() {

    CPFValidator cpfValidator = new CPFValidator();
    cpfValidator.initialize(null);

    CNPJValidator cnpjValidator = new CNPJValidator();
    cnpjValidator.initialize(null);

    return cpfValidator.isValid(cpfCnpj, null)
        || cnpjValidator.isValid(cpfCnpj, null);
  }

  public Long getPaisId() {
    return paisId;
  }

  public Long getEstadoId() {
    return estadoId;
  }

  public CriarPedidoRequest getPedido() {
    return pedido;
  }

  public void setCodigoCupom(String codigoCupom) {
    this.codigoCupom = codigoCupom;
  }

  public String getCodigoCupom() {
    return codigoCupom;
  }
}
