package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.dto.votos.VotosResponseDTO;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.model.Votos;

public class VotosMapper {

    public static Votos toModel(VotosResponseDTO dto, Usuario usuario, Opcao opcao) {
        Votos voto = new Votos();
        voto.setUsuario(usuario);
        voto.setOpcao(opcao);
        return voto;
    }

    public static VotosResponseDTO toDTO (Votos votos) {
        return new VotosResponseDTO(
                votos.getId(),
                votos.getUsuario().getId(),
                votos.getOpcao().getId()
        );
    }
}