package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.register.RegisterRequestDTO;
import com.PedroA10.Opinas.dto.register.RegisterResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

  @Override
  public RegisterResponseDTO register(RegisterRequestDTO registerDTO) {

    return new RegisterResponseDTO();
  }
}
