package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.ResponseHandler;
import com.PedroA10.Opinas.dto.login.LoginRequestDTO;
import com.PedroA10.Opinas.dto.login.LoginResponseDTO;
import com.PedroA10.Opinas.dto.register.RegisterRequestDTO;
import com.PedroA10.Opinas.security.JwtService;
import com.PedroA10.Opinas.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  @Autowired
  JwtService jwtService;

  private final AuthService authService;

  @Autowired
  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @Autowired
  AuthenticationManager authenticationManager;

  @PostMapping("/register")
  public ResponseEntity<Object> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) {
    return ResponseHandler.generateResponse("User resister successfully", HttpStatus.CREATED, authService.register(registerRequestDTO));
  }

  @PostMapping("login")
  public ResponseEntity<Object> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
    try {
      Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
      UserDetails userDetails = (UserDetails) authentication.getPrincipal();
      String jwt = jwtService.generateToken(userDetails.getUsername());
      LoginResponseDTO loginResponseDTO = LoginResponseDTO.builder()
        .accessToken(jwt)
        .build();

      return ResponseHandler.generateResponse(
        "User logged in successfully", HttpStatus.OK, loginResponseDTO
      );
    }catch (Exception e){
      return new ResponseEntity<>("Incorret username or password", HttpStatus.UNAUTHORIZED);
    }
  }
}
