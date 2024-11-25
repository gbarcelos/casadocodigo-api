package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.application.compra.CriarCompra;
import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarCompraRequest;
import br.com.oak.casadocodigoapi.infrastructure.controller.response.CompraResponse;
import br.com.oak.casadocodigoapi.infrastructure.validator.CupomValidoValidator;
import br.com.oak.casadocodigoapi.infrastructure.validator.DocumentoCpfOuCnpjValidator;
import br.com.oak.casadocodigoapi.infrastructure.validator.EstadoPertenceAoPaisValidator;
import br.com.oak.casadocodigoapi.infrastructure.validator.TotalItensCarrinhoValidator;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CriarCompraController {

  private final CriarCompra criarCompra;
  private final EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;
  private final CupomValidoValidator cupomValidoValidator;

  public CriarCompraController(CriarCompra criarCompra,
      EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator,
      CupomValidoValidator cupomValidoValidator) {
    this.criarCompra = criarCompra;
    this.estadoPertenceAoPaisValidator = estadoPertenceAoPaisValidator;
    this.cupomValidoValidator = cupomValidoValidator;
  }

  @InitBinder
  public void init(WebDataBinder binder) {
    binder.addValidators(new DocumentoCpfOuCnpjValidator());
    binder.addValidators(estadoPertenceAoPaisValidator);
    //binder.addValidators(paisTemEstadoValidator);
    binder.addValidators(new TotalItensCarrinhoValidator());
    binder.addValidators(cupomValidoValidator);
  }

  @PostMapping(value = "/compras")
  public ResponseEntity<CompraResponse> criarCompra(
      @RequestBody @Valid CriarCompraRequest criarCompraRequest) {
    Compra compra = criarCompra.execute(criarCompraRequest);
    return ResponseEntity.ok(new CompraResponse(compra));
  }
}
