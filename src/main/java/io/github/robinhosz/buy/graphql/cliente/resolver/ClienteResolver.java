package io.github.robinhosz.buy.graphql.cliente.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.entities.Compra;
import io.github.robinhosz.buy.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClienteResolver implements GraphQLResolver<Cliente> {

    @Autowired
    private CompraService compraService;

    public List<Compra> compras(Cliente cliente) {
        return compraService.findAllByCliente(cliente);
    }

}
