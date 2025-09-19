package com.PedroA10.Opinas.dto.opcao;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OpcaoRequestDTO {

    @NotEmpty(message = "O texto da opção não pode ser vazio")
    private String texto;
}