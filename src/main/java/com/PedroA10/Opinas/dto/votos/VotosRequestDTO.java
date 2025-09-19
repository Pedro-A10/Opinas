package com.PedroA10.Opinas.dto.votos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VotosRequestDTO {

    @NotNull(message = "É necessário informar o ID do usuário")
    private Long usuarioId;

    @NotNull(message = "É necessário informar o ID da opção")
    private Long opcaoId;
}
