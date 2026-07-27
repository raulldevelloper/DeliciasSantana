package com.raull.deliciassantana.services;

import com.raull.deliciassantana.dtoS.ClienteDto;
import com.raull.deliciassantana.entitys.ClienteEntity;
import com.raull.deliciassantana.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    // Listar todos os clientes
    public List<ClienteEntity> listarTodos() {
        return clienteRepository.findAll();
    }

    // Buscar pelo Id
    public ClienteEntity buscarPorId(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    // Criar Cliente
    public ClienteEntity criarCliente(ClienteDto dto) {
        ClienteEntity cliente = new ClienteEntity();

        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());

        return clienteRepository.save(cliente);
    }

    // Atualizar Cliente
    public ClienteEntity atualizarCliente(ClienteDto dto, int id) {
        ClienteEntity cliente = buscarPorId(id);

        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());

        return clienteRepository.save(cliente);
    }

    // Excluir Cliente
    public void deletar(Integer id) {
        clienteRepository.deleteById(id);
    }
}
