package br.com.oak.casadocodigoapi.validator;

import br.com.oak.casadocodigoapi.controller.request.CriarCompraRequest;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DocumentoCpfOuCnpjValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return CriarCompraRequest.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    if (errors.hasErrors()){
      return;
    }
    CriarCompraRequest request = (CriarCompraRequest) target;
    if (!request.isCpfOuCnpjValido()){
      errors.rejectValue("cpfCnpj", "DocumentoCpfOuCnpj.criarCompraRequest.cpfCnpj");
    }
  }
}
