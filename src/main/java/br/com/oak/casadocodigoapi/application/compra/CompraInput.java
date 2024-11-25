package br.com.oak.casadocodigoapi.application.compra;

import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.domain.Cupom;
import br.com.oak.casadocodigoapi.domain.Estado;
import br.com.oak.casadocodigoapi.domain.Pais;
import br.com.oak.casadocodigoapi.infrastructure.repository.CupomRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.util.StringUtils;

public interface CompraInput {

  String nome();

  String sobreNome();

  String email();

  String cpfCnpj();

  String telefone();

  String cep();

  String endereco();

  String complemento();

  String cidade();

  Long estadoId();

  Long paisId();

  CriarPedidoInput pedido();

  String codigoCupom();

  default Compra toModel(EntityManager entityManager, CupomRepository cupomRepository) {
    Compra compra = new Compra(nome(),
        sobreNome(),
        email(),
        cpfCnpj(),
        telefone(),
        cep(),
        endereco(),
        complemento(),
        cidade(),
        new Pais(paisId()),
        pedido().toModel(entityManager));

    if (estadoId() != null) {
      compra.setEstado(new Estado(estadoId()));
    }

    if (StringUtils.hasText(codigoCupom())) {
      Cupom cupom = cupomRepository.findByCodigo(codigoCupom());
      compra.aplicaCupom(cupom);
    }

    return compra;
  }

  default boolean isCpfOuCnpjValido() {

    CPFValidator cpfValidator = new CPFValidator();
    cpfValidator.initialize(null);

    CNPJValidator cnpjValidator = new CNPJValidator();
    cnpjValidator.initialize(null);

    return cpfValidator.isValid(cpfCnpj(), null)
        || cnpjValidator.isValid(cpfCnpj(), null);
  }
}
