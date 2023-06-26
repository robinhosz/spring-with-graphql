package io.github.robinhosz.buy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nome;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());;

    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras = new ArrayList<>();
}
