package com.raull.deliciassantana.controllers;

import com.raull.deliciassantana.dtoS.MesaDto;
import com.raull.deliciassantana.entitys.MesaEntity;
import com.raull.deliciassantana.services.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public ResponseEntity<List<MesaEntity>> listarTodas() {
        return ResponseEntity.ok(mesaService.listarMesas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MesaEntity> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(mesaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<MesaEntity> salvar(@RequestBody MesaDto dto) {
        return ResponseEntity.ok(mesaService.criarMesa(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        mesaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}