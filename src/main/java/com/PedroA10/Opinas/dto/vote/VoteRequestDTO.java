package com.PedroA10.Opinas.dto.vote;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VoteRequestDTO {

    @NotNull(message = "User ID required")
    private Long userId;

    @NotNull(message = "Option ID required")
    private Long optionId;
}
