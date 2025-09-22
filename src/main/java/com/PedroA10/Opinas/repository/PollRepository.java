package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    List<Poll> findByTitleContainingIgnoreCase(String text);

}
