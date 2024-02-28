package br.com.oak.casadocodigoapi.controller.request;

import jakarta.validation.constraints.NotBlank;

public class CriarCategoriaRequest {
    @NotBlank
    private String nome;

    @Deprecated
    public CriarCategoriaRequest() {
    }

    public CriarCategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
