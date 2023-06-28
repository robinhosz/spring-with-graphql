package io.github.robinhosz.buy.graphql.cliente.mutation;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.entities.Compra;
import io.github.robinhosz.buy.graphql.cliente.input.ClienteInput;
import io.github.robinhosz.buy.graphql.cliente.query.ClienteQuery;
import io.github.robinhosz.buy.graphql.exceptions.EmailNotFoundException;
import io.github.robinhosz.buy.repositories.ClienteRepository;
import io.github.robinhosz.buy.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.Timestamp;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureGraphQlTester
class ClienteMutationTest {

    @Autowired
    GraphQlTester graphQlTester;

    @InjectMocks
    private ClienteMutation clienteMutation;  // Certifique-se de que o objeto ClienteQuery esteja corretamente injetado

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveClienteShouldReturnSavedCliente() {
        String document = """
        mutation saveCliente($cliente: ClienteInput) {
            saveCliente(cliente: $cliente) {
                id
                nome
                email
                createdAt
            }
        }
    """;

        Map<String, Object> clienteInput = new HashMap<>();
        clienteInput.put("id", null);
        clienteInput.put("nome", "john");
        clienteInput.put("email", "john@gmail.com");

        graphQlTester.document(document)
                .variable("cliente", clienteInput)
                .execute()
                .path("saveCliente")
                .entity(Cliente.class)
                .satisfies(cliente -> {
                    assertNotNull(cliente.getId());
                    assertEquals("john", cliente.getNome());
                    assertEquals("john@gmail.com", cliente.getEmail());
                    assertNotNull(cliente.getCreatedAt());
                });
    }


    @Test
    void testSaveClienteWithExistingEmailShouldThrowException() {

        // Mock dos clientes existentes (nenhum deles possui o mesmo e-mail)
        List<Cliente> clientes = Arrays.asList(
                new Cliente(1L, "Alice", "alice@example.com", new Timestamp(System.currentTimeMillis()), new ArrayList<Compra>()),
                new Cliente(2L, "claudia", "claudia@gmail.com", new Timestamp(System.currentTimeMillis()), new ArrayList<Compra>()),
                new Cliente(2L, "Bob", "bob@example.com", new Timestamp(System.currentTimeMillis()), new ArrayList<Compra>())
        );

        // Configuração do mock do repositório de clientes
        when(clienteRepository.findAll()).thenReturn(clientes);


        try {
            clienteService.saveCliente(clientes.get(1));
            // Verificação do método de validação de e-mail

        } catch (EmailNotFoundException e) {
            assertEquals("Email já cadastrado", e.getMessage());
        }
    }


    @Test
    void deleteCliente() {
    }
}