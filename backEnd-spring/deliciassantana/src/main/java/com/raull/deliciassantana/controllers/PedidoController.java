package com.raull.deliciassantana.controllers;

import com.raull.deliciassantana.dtoS.PedidoDto;
import com.raull.deliciassantana.entitys.PedidoEntity;
import com.raull.deliciassantana.enums.StatusPedido;
import com.raull.deliciassantana.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoEntity>> listarTodos() {
        return ResponseEntity.ok(pedidoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoEntity> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PedidoEntity> criar(@RequestBody PedidoDto dto) {
        return ResponseEntity.ok(pedidoService.criar(dto));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PedidoEntity> atualizarStatus(@PathVariable Integer id, @RequestParam StatusPedido status) {
        return ResponseEntity.ok(pedidoService.atualizarStatus(id, status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}