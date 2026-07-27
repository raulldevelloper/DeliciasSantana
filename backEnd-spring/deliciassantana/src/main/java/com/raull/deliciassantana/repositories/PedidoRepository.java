package com.raull.deliciassantana.repositories;

import com.raull.deliciassantana.entitys.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {
    List<PedidoEntity> findByClienteId(int clienteId);
    List<PedidoEntity> findByMesaId(int mesaId);
}
