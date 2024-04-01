package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Table(name = "pedidos")
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private @NotNull
  @Valid Compra compra;

  @ElementCollection
  private @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

  public Pedido(Compra compra,
      Set<ItemPedido> itens) {
    this.compra = compra;
    this.itens.addAll(itens);
  }

  public BigDecimal total() {
    return itens.stream().map(ItemPedido::total).reduce(BigDecimal.ZERO,
        (atual, proximo) -> atual.add(proximo));
  }
}
