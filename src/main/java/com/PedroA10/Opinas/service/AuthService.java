package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.register.RegisterRequestDTO;
import com.PedroA10.Opinas.dto.register.RegisterResponseDTO;

public interface AuthService {

  RegisterResponseDTO register(RegisterRequestDTO registerDTO);
}
