package com.PedroA10.Opinas.dto.enquete;

import com.PedroA10.Opinas.dto.opcao.OpcaoResponseDTO;
import com.PedroA10.Opinas.dto.usuario.UsuarioResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class EnqueteResponseDTO {

    private Long id;
    private String titulo;
    private String mensagem;
    private String criadoPor;
    private UsuarioResponseDTO usuario;
    private List<OpcaoResponseDTO> opcoes;
}
