package com.raull.deliciassantana.controllers;

import com.raull.deliciassantana.dtoS.ClienteDto;
import com.raull.deliciassantana.entitys.ClienteEntity;
import com.raull.deliciassantana.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> salvar(@RequestBody ClienteDto dto) {
        return ResponseEntity.ok(clienteService.criarCliente(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteEntity> atualizar(@PathVariable int id, @RequestBody ClienteDto dto) {
        return ResponseEntity.ok(clienteService.atualizarCliente(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}