package com.raull.deliciassantana.dtoS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoDto {
    private Integer cardapioId;
    private int quantidade;
    private String observacao;
}
