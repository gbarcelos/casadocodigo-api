package br.com.oak.casadocodigoapi.validator;

import br.com.oak.casadocodigoapi.controller.request.CriarCategoriaRequest;
import br.com.oak.casadocodigoapi.model.Categoria;
import br.com.oak.casadocodigoapi.repository.CategoriaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NomeCategoriaDuplicadoValidatorTest {

    @Mock
    private CategoriaRepository repository;

    @InjectMocks
    private NomeCategoriaDuplicadoValidator nomeCategoriaDuplicadoValidator;

    @Test
    @DisplayName("Deve retornar erro quando o nome ja cadastrado")
    public void deveRetornarErroQuandoNomeJaCadastrado() {
        //Dado
        when(repository.findByNome(any())).thenReturn(
                Optional.of(new Categoria("nome de alguma categoria")));

        final var criarCategoriaRequest = new CriarCategoriaRequest("nome de alguma categoria");
        final var errors = new BeanPropertyBindingResult(criarCategoriaRequest,
                "criarCategoriaRequest");

        //Quando
        nomeCategoriaDuplicadoValidator.validate(criarCategoriaRequest, errors);

        //Entao
        assertTrue(errors.hasErrors());
    }

    @Test
    @DisplayName("Nao deve retornar erro quando o nome nao cadastrado")
    public void naoDeveRetornarErroQuandoNomeNaoCadastrado() {
        //Dado
        when(repository.findByNome(any())).thenReturn(
                Optional.empty());

        final var criarCategoriaRequest = new CriarCategoriaRequest("nome de alguma categoria");
        final var errors = new BeanPropertyBindingResult(criarCategoriaRequest,
                "criarCategoriaRequest");

        //Quando
        nomeCategoriaDuplicadoValidator.validate(criarCategoriaRequest, errors);

        //Entao
        assertFalse(errors.hasErrors());
    }
}