package io.github.robinhosz.buy.graphql.cliente.query;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClienteQuery {

    @Autowired
    private ClienteService clienteService;


    @QueryMapping
    public String hello() {
        return "Hello";
    }

    @QueryMapping
    public Cliente getClienteById(@Argument Long id) {
        return clienteService.getClienteById(id);
    }

    @QueryMapping
    public List<Cliente> findAllClientes() {
        return clienteService.findAllClientes();
    }

}