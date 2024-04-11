package br.com.oak.casadocodigoapi.controller;

import br.com.oak.casadocodigoapi.controller.request.CriarCompraRequest;
import br.com.oak.casadocodigoapi.model.Compra;
import br.com.oak.casadocodigoapi.repository.CupomRepository;
import br.com.oak.casadocodigoapi.validator.CupomValidoValidator;
import br.com.oak.casadocodigoapi.validator.DocumentoCpfOuCnpjValidator;
import br.com.oak.casadocodigoapi.validator.EstadoPertenceAoPaisValidator;
import br.com.oak.casadocodigoapi.validator.TotalItensCarrinhoValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ComprasController {

  @PersistenceContext
  private EntityManager entityManager;

  @Autowired
  private CupomRepository cupomRepository;

  @Autowired
  private EstadoPertenceAoPaisValidator estadoPertenceAoPaisValidator;

  @Autowired
  private CupomValidoValidator cupomValidoValidator;

  @InitBinder
  public void init(WebDataBinder binder){
    binder.addValidators(new DocumentoCpfOuCnpjValidator());
    binder.addValidators(estadoPertenceAoPaisValidator);
    //binder.addValidators(paisTemEstadoValidator);
    binder.addValidators(new TotalItensCarrinhoValidator());
    binder.addValidators(cupomValidoValidator);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<Object> criarCompra(
      @RequestBody @Valid CriarCompraRequest criarCompraRequest) {
    Compra compra = criarCompraRequest.toModel(cupomRepository);
    entityManager.persist(compra);
    return ResponseEntity.ok(compra.toString());
  }
}
