package com.PedroA10.Opinas.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String nome;

    @NotEmpty
    @Email
    private String email;
}
