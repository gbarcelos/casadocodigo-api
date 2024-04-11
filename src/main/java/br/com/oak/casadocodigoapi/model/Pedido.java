package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import org.springframework.util.Assert;

@Entity
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private @NotNull
  @Valid Compra compra;

  @ElementCollection
  private @Size(min = 1) Set<ItemPedido> itens = new HashSet<>();

  public Pedido(@NotNull @Valid Compra compra,
      @Size(min = 1) Set<ItemPedido> itens) {
    Assert.isTrue(itens.iterator().hasNext(),
        "Pedido deve ter pelo menos um item");
    this.compra = compra;
    this.itens.addAll(itens);
  }

  public Integer total() {
    return itens.stream().map(ItemPedido::getQuantidade).reduce(0, Integer::sum);
  }

  public boolean totalIgual(@Positive @NotNull Integer valor) {
    return total().compareTo(valor) != 0;
  }

  @Override
  public String toString() {
    return "Pedido{" +
        "id=" + id +
        ", itens=" + itens +
        '}';
  }
}
