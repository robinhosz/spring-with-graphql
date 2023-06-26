package io.github.robinhosz.buy.graphql.cliente.mutation;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.graphql.cliente.input.ClienteInput;
import io.github.robinhosz.buy.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteMutation {

    @Autowired
    private ClienteService clienteService;


    @MutationMapping
    public Cliente saveCliente(@Argument ClienteInput cliente) {
        Cliente clienteEntity = Cliente.builder()
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .build();
        return clienteService.saveCliente(clienteEntity);
    }

    @MutationMapping
    public Boolean deleteCliente(@Argument Long id) {

        return clienteService.deleteCliente(id);
    }
}
