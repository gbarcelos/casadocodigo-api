package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Table(name = "categorias")
@Entity(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;

    @Deprecated
    public Categoria() {
    }

    public Categoria(Long id) {
        this.id = id;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
}
