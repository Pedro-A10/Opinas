package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Enquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EnqueteRepository extends JpaRepository<Enquete, Long> {

    List<Enquete> findByTituloContainingIgnoreCase(String text);

}
