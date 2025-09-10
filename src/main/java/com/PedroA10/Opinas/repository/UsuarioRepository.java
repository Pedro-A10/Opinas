package com.PedroA10.Opinas.repository;

import com.PedroA10.Opinas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
