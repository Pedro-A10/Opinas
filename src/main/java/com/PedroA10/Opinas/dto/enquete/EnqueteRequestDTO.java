package com.PedroA10.Opinas.dto.enquete;

import com.PedroA10.Opinas.dto.opcao.OpcaoRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class EnqueteRequestDTO {

    @NotEmpty(message = "O título é obrigatório")
    @Size(min = 5, max = 100, message = "O título deve ter entre 5 e 100 caracteres")
    private String titulo;

    @NotEmpty(message = "A descrição é obrigatória")
    @Size(max = 1000)
    private String mensagem;

    private Long usuarioId;

    private List<OpcaoRequestDTO> opcoes;
}
