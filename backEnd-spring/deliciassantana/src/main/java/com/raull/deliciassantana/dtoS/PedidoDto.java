package com.raull.deliciassantana.dtoS;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private Integer clienteId;
    private Integer mesaId;
    private List<ItemPedidoDto> itens;
}
