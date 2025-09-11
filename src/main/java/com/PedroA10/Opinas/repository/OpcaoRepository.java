package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Opcao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpcaoRepository extends JpaRepository<Opcao, Long> {

    List<Opcao> findByEnqueteId(Long enqueteId);
}
