package com.raull.deliciassantana.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "item_pedido")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    @JsonIgnore
    private PedidoEntity pedido;

    @ManyToOne
    @JoinColumn(name = "cardapio_id")
    private CardapioEntity cardapio;

    private int quantidade;
    private String observacao;
}
