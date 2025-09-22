package com.PedroA10.Opinas.dto.option;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class OptionRequestDTO {

    @NotEmpty(message = "Option text cannot be empty")
    private String text;
}