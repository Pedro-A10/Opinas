package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Votos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VotosRepository extends JpaRepository<Votos, Long> {

    List<Votos> findByOpcaoId(Long opcaoId);
    Long countByOpcaoId(Long opcaoId);
}
