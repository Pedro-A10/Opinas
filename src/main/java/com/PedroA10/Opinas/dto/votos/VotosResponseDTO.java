package com.PedroA10.Opinas.dto.votos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VotosResponseDTO {
    private Long id;
    private Long usuarioId;
    private Long opcaoId;
}
