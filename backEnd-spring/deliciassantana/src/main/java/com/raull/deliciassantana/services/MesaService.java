package com.raull.deliciassantana.services;

import com.raull.deliciassantana.dtoS.MesaDto;
import com.raull.deliciassantana.entitys.MesaEntity;
import com.raull.deliciassantana.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    // Listar todas as mesas
    public List<MesaEntity> listarMesas() {
        return mesaRepository.findAll();
    }

    // Buscar pelo ID
    public MesaEntity buscarPorId(Integer id) {
        return mesaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));
    }

    // Criar Mesa
    public MesaEntity criarMesa(MesaDto dto) {
        MesaEntity mesa = new MesaEntity();

        mesa.setCategoria(dto.getCategoria());

        return mesaRepository.save(mesa);
    }


    // Deletar Mesa
    public void deletar(Integer id) {
        mesaRepository.deleteById(id);
    }
}
