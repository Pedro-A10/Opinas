package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.opcao.OpcaoRequestDTO;
import com.PedroA10.Opinas.dto.opcao.OpcaoResponseDTO;
import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Opcao;

public class OpcaoMapper {

    public static Opcao toModel(OpcaoRequestDTO dto) {
        Opcao opcao = new Opcao();
        opcao.setTexto(dto.getTexto());
        return opcao;
    }

    public static OpcaoResponseDTO toDTO(Opcao opcao) {
        return new OpcaoResponseDTO(opcao.getId(), opcao.getTexto());
    }
}