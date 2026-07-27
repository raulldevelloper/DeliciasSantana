package com.raull.deliciassantana.controllers;

import com.raull.deliciassantana.dtoS.CardapioDto;
import com.raull.deliciassantana.entitys.CardapioEntity;
import com.raull.deliciassantana.services.CardapioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping
    public ResponseEntity<List<CardapioEntity>> listarTodos() {
        return ResponseEntity.ok(cardapioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardapioEntity> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(cardapioService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<CardapioEntity> salvar(@RequestBody CardapioDto dto) {
        return ResponseEntity.ok(cardapioService.criarCardapio(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardapioEntity> atualizar(@PathVariable Integer id, @RequestBody CardapioDto dto) {
        return ResponseEntity.ok(cardapioService.atualizarCardapio(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        cardapioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
