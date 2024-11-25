package br.com.oak.casadocodigoapi.infrastructure.controller.request;

import br.com.oak.casadocodigoapi.application.livro.LivroInput;
import br.com.oak.casadocodigoapi.domain.Autor;
import br.com.oak.casadocodigoapi.domain.Categoria;
import br.com.oak.casadocodigoapi.domain.Livro;
import br.com.oak.casadocodigoapi.infrastructure.annotation.ExistsValue;
import br.com.oak.casadocodigoapi.infrastructure.annotation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

public record CriarLivroRequest(

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    String titulo,

    @NotBlank
    @Size(min = 1, max = 500)
    String resumo,

    @NotBlank
    String sumario,

    @NotNull
    @DecimalMin(value = "20.0")
    @Digits(integer = 3, fraction = 2)
    BigDecimal preco,

    @NotNull
    @Min(value = 100)
    Integer numeroDePaginas,

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    String isbn,

    @NotNull
    @Future
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    LocalDate dataPublicacao,

    @NotNull
    @ExistsValue(domainClass = Categoria.class)
    Long categoriaId,

    @NotNull
    @ExistsValue(domainClass = Autor.class)
    Long autorId
) implements LivroInput {

}
