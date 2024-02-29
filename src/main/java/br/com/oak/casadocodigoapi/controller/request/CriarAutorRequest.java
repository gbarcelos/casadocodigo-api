package br.com.oak.casadocodigoapi.controller.request;

import br.com.oak.casadocodigoapi.annotation.UniqueValue;
import br.com.oak.casadocodigoapi.model.Autor;
import br.com.oak.casadocodigoapi.model.Categoria;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CriarAutorRequest {
    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email")
    private String email;

    @NotBlank
    @Size(min = 1, max = 400)
    private String descricao;

    public CriarAutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toModel() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getEmail() {
        return email;
    }
}
