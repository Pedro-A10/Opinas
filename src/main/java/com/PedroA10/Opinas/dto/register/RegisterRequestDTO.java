package com.PedroA10.Opinas.dto.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterRequestDTO {

  @NotBlank(message = "Username is required")
  @Size(min = 5, max = 20, message = "Username must be between 5 and 20 characters.")
  private String username;

  @NotBlank(message = "Password is required")
  @Size(min = 8, message = "Password must be at least 8 characters.")
  private String password;

  @NotBlank(message = "Email is required")
  @Email(message = "Email should be valid")
  private String email;
}
