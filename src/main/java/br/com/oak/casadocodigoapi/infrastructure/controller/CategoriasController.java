package br.com.oak.casadocodigoapi.infrastructure.controller;

import br.com.oak.casadocodigoapi.application.categoria.CriarCategoria;
import br.com.oak.casadocodigoapi.domain.Categoria;
import br.com.oak.casadocodigoapi.infrastructure.controller.request.CriarCategoriaRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

  private CriarCategoria criarCategoria; //1

  public CategoriasController(CriarCategoria criarCategoria) {
    this.criarCategoria = criarCategoria;
  }

  @PostMapping
  public ResponseEntity<Object> criarCategoria(
      @RequestBody @Valid CriarCategoriaRequest criarCategoriaRequest) {
    Categoria categoria = criarCategoria.execute(criarCategoriaRequest); //1
    return ResponseEntity.ok(categoria.toString());
  }
}
