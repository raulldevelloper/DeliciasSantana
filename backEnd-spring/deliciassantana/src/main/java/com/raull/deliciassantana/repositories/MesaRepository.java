package com.raull.deliciassantana.repositories;

import com.raull.deliciassantana.entitys.MesaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<MesaEntity, Integer> {
}
