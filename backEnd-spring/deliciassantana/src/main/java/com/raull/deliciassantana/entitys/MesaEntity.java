package com.raull.deliciassantana.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mesa")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MesaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoria;

    @OneToMany(mappedBy = "mesa")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<PedidoEntity> pedidos = new ArrayList<>();
}
