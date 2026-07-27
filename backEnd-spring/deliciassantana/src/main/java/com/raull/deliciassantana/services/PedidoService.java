package com.raull.deliciassantana.services;

import com.raull.deliciassantana.dtoS.ItemPedidoDto;
import com.raull.deliciassantana.dtoS.PedidoDto;
import com.raull.deliciassantana.entitys.CardapioEntity;
import com.raull.deliciassantana.entitys.ClienteEntity;
import com.raull.deliciassantana.entitys.ItemPedidoEntity;
import com.raull.deliciassantana.entitys.MesaEntity;
import com.raull.deliciassantana.entitys.PedidoEntity;
import com.raull.deliciassantana.enums.StatusPedido;
import com.raull.deliciassantana.repositories.CardapioRepository;
import com.raull.deliciassantana.repositories.ClienteRepository;
import com.raull.deliciassantana.repositories.MesaRepository;
import com.raull.deliciassantana.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MesaRepository mesaRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    public List<PedidoEntity> listarTodos() {
        return pedidoRepository.findAll();
    }

    public PedidoEntity buscarPorId(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public PedidoEntity criar(PedidoDto dto) {
        ClienteEntity cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        MesaEntity mesa = mesaRepository.findById(dto.getMesaId())
                .orElseThrow(() -> new RuntimeException("Mesa não encontrada"));

        PedidoEntity pedido = new PedidoEntity();
        pedido.setCliente(cliente);
        pedido.setMesa(mesa);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(StatusPedido.ABERTO);

        List<ItemPedidoEntity> itens = new ArrayList<>();
        for (ItemPedidoDto itemDto : dto.getItens()) {
            CardapioEntity prato = cardapioRepository.findById(itemDto.getCardapioId())
                    .orElseThrow(() -> new RuntimeException("Prato não encontrado: id " + itemDto.getCardapioId()));

            ItemPedidoEntity item = new ItemPedidoEntity();
            item.setPedido(pedido);
            item.setCardapio(prato);
            item.setQuantidade(itemDto.getQuantidade());
            item.setObservacao(itemDto.getObservacao());

            itens.add(item);
        }

        pedido.setItens(itens);
        return pedidoRepository.save(pedido);
    }

    public PedidoEntity atualizarStatus(Integer id, StatusPedido novoStatus) {
        PedidoEntity pedido = buscarPorId(id);
        pedido.setStatus(novoStatus);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
