package io.github.robinhosz.buy.graphql.cliente.input;

import io.github.robinhosz.buy.entities.Compra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteInput {

    private Long id;
    private String email;
    private String nome;

    public ClienteInput(Long id, String email, String nome) {
        this.id = id;
        this.email = email;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
