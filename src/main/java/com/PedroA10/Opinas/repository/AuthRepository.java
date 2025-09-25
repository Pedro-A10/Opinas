package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<User, Long> {

  User findByUsername(String Username);

}
