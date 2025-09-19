package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.usuario.UsuarioRequestDTO;
import com.PedroA10.Opinas.dto.usuario.UsuarioResponseDTO;
import com.PedroA10.Opinas.model.Usuario;
import jakarta.validation.Valid;

public class UsuarioMapper {

    public static UsuarioResponseDTO toDTO (Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    public static Usuario toModel (@Valid UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        return usuario;
    }
}
