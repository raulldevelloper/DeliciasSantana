package com.raull.deliciassantana.services;

import com.raull.deliciassantana.dtoS.CardapioDto;
import com.raull.deliciassantana.entitys.CardapioEntity;
import com.raull.deliciassantana.repositories.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardapioService {
    @Autowired
    private CardapioRepository cardapioRepository;

    // Listar todos os pratos
    public List<CardapioEntity> listarTodos() {
        return cardapioRepository.findAll();
    }

    // Listar pelo id
    public CardapioEntity buscarPorId(Integer id) {
        return cardapioRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Prato não encontrado"));
    }

    // Criar Cardapio
    public CardapioEntity criarCardapio(CardapioDto dto) {
        CardapioEntity cardapio = new CardapioEntity();

        cardapio.setTipoDoPrato(dto.getTipoDoPrato());
        cardapio.setDescricao(dto.getDescricao());

        return cardapioRepository.save(cardapio);
    }

    // Atualizar prato
    public CardapioEntity atualizarCardapio(CardapioDto dto, Integer id) {
        CardapioEntity cardapio = buscarPorId(id);

        cardapio.setTipoDoPrato(dto.getTipoDoPrato());
        cardapio.setDescricao(dto.getDescricao());

        return cardapioRepository.save(cardapio);
    }

    public void deletar(Integer id) {
        cardapioRepository.deleteById(id);
    }
}
