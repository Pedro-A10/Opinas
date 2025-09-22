package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByOptionId(Long optionId);
    Long countByOptionId(Long optionId);
}
