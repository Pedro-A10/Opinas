package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.enquete.EnqueteRequestDTO;
import com.PedroA10.Opinas.dto.enquete.EnqueteResponseDTO;

import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.service.EnqueteService;
import com.PedroA10.Opinas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquetes")
public class EnqueteController {

    @Autowired
    private EnqueteService enqueteService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<EnqueteResponseDTO> listarEnquetes() {
        return enqueteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnqueteResponseDTO> listarEnquetesPorId(@PathVariable Long id) {
        return enqueteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EnqueteResponseDTO> criarEnquete(@RequestBody @Valid EnqueteRequestDTO enqueteRequestDTO) {
        Usuario usuario = usuarioService.findEntityById(enqueteRequestDTO.getUsuarioId());
        EnqueteResponseDTO novaEnquete = enqueteService.criarEnquete(enqueteRequestDTO, usuario);
        return new ResponseEntity<>(novaEnquete, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnquete(@PathVariable Long id) {
        try {
            enqueteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}