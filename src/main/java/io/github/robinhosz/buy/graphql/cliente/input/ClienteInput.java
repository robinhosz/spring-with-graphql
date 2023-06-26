package io.github.robinhosz.buy.graphql.cliente.input;

import io.github.robinhosz.buy.entities.Compra;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClienteInput {

    private Long id;
    private String email;
    private String nome;

    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

}
