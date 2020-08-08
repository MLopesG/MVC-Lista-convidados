package com.mvc.app.repository;

import com.mvc.app.model.ConvidadoModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConvidadoRepository extends JpaRepository<ConvidadoModel, Long> {
    @Query(value = "SELECT sum(QUANTIDADE_ACOMPANHANTES ) FROM CONVIDADO_MODEL", nativeQuery = true)
    Long findBySum();
}