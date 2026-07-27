package com.raull.deliciassantana.controllers;

import com.raull.deliciassantana.dtoS.ItemPedidoDto;
import com.raull.deliciassantana.entitys.ItemPedidoEntity;
import com.raull.deliciassantana.services.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos/{pedidoId}/itens")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping
    public ResponseEntity<List<ItemPedidoEntity>> listarPorPedido(@PathVariable Integer pedidoId) {
        return ResponseEntity.ok(itemPedidoService.listarPorPedido(pedidoId));
    }

    @PostMapping
    public ResponseEntity<ItemPedidoEntity> adicionar(@PathVariable Integer pedidoId, @RequestBody ItemPedidoDto dto) {
        return ResponseEntity.ok(itemPedidoService.adicionarItem(pedidoId, dto));
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemPedidoEntity> atualizar(@PathVariable Integer itemId, @RequestBody ItemPedidoDto dto) {
        return ResponseEntity.ok(itemPedidoService.atualizarItem(itemId, dto));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> remover(@PathVariable Integer itemId) {
        itemPedidoService.removerItem(itemId);
        return ResponseEntity.noContent().build();
    }
}
