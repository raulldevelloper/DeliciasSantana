package com.raull.deliciassantana.repositories;

import com.raull.deliciassantana.entitys.CardapioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardapioRepository extends JpaRepository<CardapioEntity, Integer> {
}
