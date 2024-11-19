package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarCompraRequest;
import br.com.oak.casadocodigoapi.infrastructure.controller.response.CompraResponse;
import br.com.oak.casadocodigoapi.domain.Compra;
import br.com.oak.casadocodigoapi.infrastructure.repository.CupomRepository;
import br.com.oak.casadocodigoapi.infrastructure.validator.CupomValidoValidator;
import br.com.oak.casadocodigoapi.infrastructure.validator.DocumentoCpfOuCnpjValidator;
import br.com.oak.casadocodigoapi.infrastructure.validator.EstadoPertenceAoPaisValidator;
import br.com.oak.casadocodigoapi.infrastructure.validator.TotalItensCarrinhoValidator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
  public void init(WebDataBinder binder) {
    binder.addValidators(new DocumentoCpfOuCnpjValidator());
    binder.addValidators(estadoPertenceAoPaisValidator);
    //binder.addValidators(paisTemEstadoValidator);
    binder.addValidators(new TotalItensCarrinhoValidator());
    binder.addValidators(cupomValidoValidator);
  }

  @PostMapping
  @Transactional
  public ResponseEntity<CompraResponse> criarCompra(
      @RequestBody @Valid CriarCompraRequest criarCompraRequest) {
    Compra compra = criarCompraRequest.toModel(entityManager, cupomRepository);
    entityManager.persist(compra);
    return ResponseEntity.ok(new CompraResponse(compra));
  }

  @GetMapping("/{id}")
  public ResponseEntity<CompraResponse> detalharCompra(@PathVariable Long id) {

    Compra compra = entityManager.find(Compra.class, id);

    if (compra == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Compra não encontrada");
    }

    return ResponseEntity.ok(new CompraResponse(compra));
  }

}
