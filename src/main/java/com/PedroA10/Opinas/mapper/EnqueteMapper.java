package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.enquete.EnqueteRequestDTO;
import com.PedroA10.Opinas.dto.enquete.EnqueteResponseDTO;
import com.PedroA10.Opinas.dto.opcao.OpcaoResponseDTO;
import com.PedroA10.Opinas.dto.usuario.UsuarioResponseDTO;
import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.model.Usuario;

public class EnqueteMapper {

    public static EnqueteResponseDTO toDTO(Enquete enquete) {
        EnqueteResponseDTO dto = new EnqueteResponseDTO();
        dto.setId(enquete.getId());
        dto.setTitulo(enquete.getTitulo());
        dto.setMensagem(enquete.getMensagem());

        UsuarioResponseDTO usuarioDTO = new UsuarioResponseDTO();
        usuarioDTO.setId(enquete.getUsuario().getId());
        usuarioDTO.setNome(enquete.getUsuario().getNome());
        usuarioDTO.setEmail(enquete.getUsuario().getEmail());
        dto.setUsuario(usuarioDTO);

        if (enquete.getOpcoes() != null) {
            dto.setOpcoes(
                    enquete.getOpcoes().stream()
                            .map(opcao -> {
                                return new OpcaoResponseDTO(opcao.getId(), opcao.getTexto());
                            })
                            .toList()
            );
        }

        return dto;
    }

    public static Enquete toModel (EnqueteRequestDTO dto, Usuario usuario) {
        Enquete enquete = new Enquete();
        enquete.setTitulo(dto.getTitulo());
        enquete.setMensagem(dto.getMensagem());
        enquete.setComentarios(dto.getMensagem());
        enquete.setUsuario(usuario);

        if (dto.getOpcoes() != null) {
            dto.getOpcoes().forEach(opcaoDTO -> {
                Opcao opcao = new Opcao();
                opcao.setTexto(opcaoDTO.getTexto());
                opcao.setEnquete(enquete);
                enquete.getOpcoes().add(opcao);
            });
        }

        return enquete;
    }
}
