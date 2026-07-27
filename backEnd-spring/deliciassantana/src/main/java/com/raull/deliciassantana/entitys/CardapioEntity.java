package com.raull.deliciassantana.entitys;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cardapio")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardapioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tipoDoPrato;
    private String descricao;
    private float preco;

    @OneToMany(mappedBy = "cardapio")
    @com.fasterxml.jackson.annotation.JsonIgnore
    private List<ItemPedidoEntity> itensPedido = new ArrayList<>();
}
