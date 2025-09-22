package com.PedroA10.Opinas.dto.poll;

import com.PedroA10.Opinas.dto.option.OptionResponseDTO;
import com.PedroA10.Opinas.dto.user.UserResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class PollResponseDTO {

    private Long id;
    private String title;
    private String message;
    private String createdBy;
    private UserResponseDTO User;
    private List<OptionResponseDTO> options;
}
