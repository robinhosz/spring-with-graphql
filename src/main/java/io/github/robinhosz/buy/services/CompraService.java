package io.github.robinhosz.buy.services;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.entities.Compra;
import io.github.robinhosz.buy.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository compraRepository;

    public List<Compra> findAllByCliente(Cliente cliente) {
        return compraRepository.findAllByCliente(cliente);
    }
}
