package br.com.oak.casadocodigoapi.domain;


import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class ItemPedido {

  @ManyToOne
  private @NotNull Livro livro;
  private @Positive int quantidade;
  @Positive
  private BigDecimal preco;

  @Deprecated
  public ItemPedido() {
  }

  public ItemPedido(@NotNull Livro livro, @Positive int quantidade) {
    this.livro = livro;
    this.quantidade = quantidade;
    this.preco = livro.getPreco();
  }

  public int getQuantidade() {
    return quantidade;
  }

  public BigDecimal total() {
    return preco.multiply(new BigDecimal(quantidade));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemPedido that = (ItemPedido) o;
    return Objects.equals(livro, that.livro);
  }

  @Override
  public int hashCode() {
    return Objects.hash(livro);
  }

  @Override
  public String toString() {
    return "ItemPedido{" +
        "livro=" + livro +
        ", quantidade=" + quantidade +
        ", preco=" + preco +
        '}';
  }
}
