package com.PedroA10.Opinas.dto.poll;

import com.PedroA10.Opinas.dto.option.OptionRequestDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class PollRequestDTO {

    @NotEmpty(message = "Title is required")
    @Size(min = 5, max = 100, message = "The title must be between 5 and 100 characters long.")
    private String title;

    @NotEmpty(message = "Description is required")
    @Size(max = 1000)
    private String message;

    private Long userId;

    private List<OptionRequestDTO> option;
}
