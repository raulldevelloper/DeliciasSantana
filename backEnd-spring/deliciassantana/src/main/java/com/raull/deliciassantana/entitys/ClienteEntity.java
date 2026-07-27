package com.raull.deliciassantana.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String nome;
    String telefone;

    @OneToMany(mappedBy = "cliente")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<PedidoEntity> pedidos = new ArrayList<>();
}
