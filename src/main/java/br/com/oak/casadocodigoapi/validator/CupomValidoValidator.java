package br.com.oak.casadocodigoapi.validator;

import br.com.oak.casadocodigoapi.controller.request.CriarCompraRequest;
import br.com.oak.casadocodigoapi.model.Cupom;
import br.com.oak.casadocodigoapi.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CupomValidoValidator implements Validator {

  @Autowired
  private CupomRepository cupomRepository;

  @Override
  public boolean supports(Class<?> clazz) {
    return CriarCompraRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    if (errors.hasErrors()) {
      return;
    }
    CriarCompraRequest request = (CriarCompraRequest) target;

    if (!StringUtils.hasText(request.getCodigoCupom())) {
      return;
    }

    Cupom cupom = cupomRepository.findByCodigo(request.getCodigoCupom());
    if (!cupom.isValido()) {
      errors.rejectValue("codigoCupom", "CupomValido.criarCompraRequest.codigoCupom");
    }
  }
}
