package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    boolean ExistsByEmail(String email);
}
