package com.raull.deliciassantana.services;

import com.raull.deliciassantana.dtoS.ItemPedidoDto;
import com.raull.deliciassantana.entitys.CardapioEntity;
import com.raull.deliciassantana.entitys.ItemPedidoEntity;
import com.raull.deliciassantana.entitys.PedidoEntity;
import com.raull.deliciassantana.repositories.CardapioRepository;
import com.raull.deliciassantana.repositories.ItemPedidoRepository;
import com.raull.deliciassantana.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private CardapioRepository cardapioRepository;

    public List<ItemPedidoEntity> listarPorPedido(Integer pedidoId) {
        return itemPedidoRepository.findByPedidoId(pedidoId);
    }

    public ItemPedidoEntity buscarPorId(Integer id) {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
    }

    public ItemPedidoEntity adicionarItem(Integer pedidoId, ItemPedidoDto dto) {
        PedidoEntity pedido = pedidoRepository.findById(pedidoId)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        CardapioEntity prato = cardapioRepository.findById(dto.getCardapioId())
                .orElseThrow(() -> new RuntimeException("Prato não encontrado"));

        ItemPedidoEntity item = new ItemPedidoEntity();
        item.setPedido(pedido);
        item.setCardapio(prato);
        item.setQuantidade(dto.getQuantidade());
        item.setObservacao(dto.getObservacao());

        return itemPedidoRepository.save(item);
    }

    public ItemPedidoEntity atualizarItem(Integer id, ItemPedidoDto dto) {
        ItemPedidoEntity item = buscarPorId(id);

        if (!item.getCardapio().getId().equals(dto.getCardapioId())) {
            CardapioEntity prato = cardapioRepository.findById(dto.getCardapioId())
                    .orElseThrow(() -> new RuntimeException("Prato não encontrado"));
            item.setCardapio(prato);
        }

        item.setQuantidade(dto.getQuantidade());
        item.setObservacao(dto.getObservacao());

        return itemPedidoRepository.save(item);
    }

    public void removerItem(Integer id) {
        itemPedidoRepository.deleteById(id);
    }
}
