package br.com.oak.casadocodigoapi.validator;

import br.com.oak.casadocodigoapi.controller.request.CriarAutorRequest;
import br.com.oak.casadocodigoapi.model.Autor;
import br.com.oak.casadocodigoapi.repository.AutorRepository;
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
public class EmailDuplicadoAutorValidatorTest {

    @Mock
    private AutorRepository autorRepository;

    @InjectMocks
    private EmailAutorDuplicadoValidator emailAutorDuplicadoValidator;

    @Test
    @DisplayName("Deve retornar erro quando o email ja cadastrado")
    public void deveRetornarErroQuandoOEmailJaCadastrado() {
        //Dado
        when(autorRepository.findByEmail(any())).thenReturn(
                Optional.of(new Autor("fulano",
                        "fulano@test.com",
                        "descricao do fulano")));

        final var criarAutorRequest = new CriarAutorRequest(
                "beltrano",
                "fulano@test.com",
                "descricao do beltrano");
        final var errors = new BeanPropertyBindingResult(criarAutorRequest,
                "criarAutorRequest");

        //Quando
        emailAutorDuplicadoValidator.validate(criarAutorRequest, errors);

        //Entao
        assertTrue(errors.hasErrors());
    }

    @Test
    @DisplayName("Nao deve retornar erro quando o email nao cadastrado")
    public void naoDeveRetornarErroQuandoEmailNaoCadastrado() {
        //Dado
        when(autorRepository.findByEmail(any())).thenReturn(
                Optional.empty());

        final var criarAutorRequest = new CriarAutorRequest(
                "beltrano",
                "fulano@test.com",
                "descricao do beltrano");
        final var errors = new BeanPropertyBindingResult(criarAutorRequest,
                "criarAutorRequest");

        //Quando
        emailAutorDuplicadoValidator.validate(criarAutorRequest, errors);

        //Entao
        assertFalse(errors.hasErrors());
    }
}