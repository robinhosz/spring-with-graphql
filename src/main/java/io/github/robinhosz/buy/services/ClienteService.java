package io.github.robinhosz.buy.services;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.graphql.exceptions.EmailNotFoundException;
import io.github.robinhosz.buy.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getClienteById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente saveCliente(Cliente cliente) {

        validationEmail(cliente);

        return clienteRepository.save(cliente);
    }

    @Transactional
    public Boolean deleteCliente(Long id) {

        if(clienteRepository.findById(id).isPresent()) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public void validationEmail(Cliente cliente) {
        List<Cliente> clientes = findAllClientes();

        clientes.forEach(c -> {
            if(cliente.getEmail().equals(c.getEmail())) {
                throw new EmailNotFoundException("Email já cadastrado");
            }
        });
    }
}