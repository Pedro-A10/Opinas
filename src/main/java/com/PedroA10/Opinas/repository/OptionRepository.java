package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Long> {

    List<Option> findByPollId(Long pollId);
}
