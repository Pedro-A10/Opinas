package com.PedroA10.Opinas.dto.vote;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VoteResponseDTO {
    private Long id;
    private Long userId;
    private Long optionId;
}
