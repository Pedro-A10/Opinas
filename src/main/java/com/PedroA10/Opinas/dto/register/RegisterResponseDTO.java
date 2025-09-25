package com.PedroA10.Opinas.dto.register;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterResponseDTO {
  private Long id;
  private String username;
  private String email;

}
