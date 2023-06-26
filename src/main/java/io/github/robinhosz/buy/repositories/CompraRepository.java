package io.github.robinhosz.buy.repositories;

import io.github.robinhosz.buy.entities.Cliente;
import io.github.robinhosz.buy.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {
    List<Compra> findAllByCliente(Cliente cliente);
}
