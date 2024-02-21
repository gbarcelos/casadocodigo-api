package br.com.oak.casadocodigoapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Table(name = "autores")
@Entity(name = "Autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private final String nome;
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @Size(min = 1, max = 400)
    private final String descricao;
    private final LocalDateTime dataHoraCriacao = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }
}
