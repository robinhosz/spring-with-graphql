package io.github.robinhosz.buy.graphql.cliente.query;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.repositories.ClienteRepository;
import io.github.robinhosz.buy.services.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
@AutoConfigureGraphQlTester
class ClienteQueryTest {


    @Autowired
    GraphQlTester graphQlTester;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testValidIdShouldReturnCliente() {

        String document = """
                
                query getClienteById($id: ID){
                   getClienteById(id: $id) {
                     id
                     nome
                     email
                   }
                }
                
                """;

        graphQlTester.document(document)
                .variable("id", 3)
                .execute()
                .path("getClienteById")
                .entity(Cliente.class)
                .satisfies(cliente -> {
                   assertEquals("rob", cliente.getNome());
                    assertEquals("rob@gmail.com", cliente.getEmail());
                });

    }

    @Test
    void testFindAllClientesShouldReturnAllClientes() {

        String document = """
                query {
                  findAllClientes {
                  id
                  nome,
                  email
                  }
                }
                """;

        graphQlTester.document(document)
                .execute()
                .path("findAllClientes")
                .entityList(Cliente.class)
                .hasSize(3);

    }
}