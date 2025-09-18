package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.UsuarioDTO;
import com.PedroA10.Opinas.model.Usuario;

public class UsuarioMapper {

    public static UsuarioDTO toDTO (Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        return dto;
    }

    public static Usuario toEntity (UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        return usuario;
    }
}
