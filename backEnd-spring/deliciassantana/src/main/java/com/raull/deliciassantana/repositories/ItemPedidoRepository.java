package com.raull.deliciassantana.repositories;

import com.raull.deliciassantana.entitys.ItemPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Integer> {

    List<ItemPedidoEntity> findByPedidoId(Integer pedidoId);
}