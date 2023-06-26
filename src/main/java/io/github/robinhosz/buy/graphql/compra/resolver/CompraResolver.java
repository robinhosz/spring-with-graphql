package io.github.robinhosz.buy.graphql.compra.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.entities.Compra;
import io.github.robinhosz.buy.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

public class CompraResolver implements GraphQLResolver<Compra> {


    @Autowired
    private ClienteService clienteService;

    public Cliente cliente(Compra compra) {
        return clienteService.getClienteById(compra.getCliente().getId());
    }

}
