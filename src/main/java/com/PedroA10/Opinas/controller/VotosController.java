package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.votos.VotosResponseDTO;
import com.PedroA10.Opinas.model.Votos;
import com.PedroA10.Opinas.service.VotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votos")
public class VotosController {

    @Autowired
    private VotosService votosService;

    @PostMapping
        public ResponseEntity<VotosResponseDTO> votar(@RequestParam Long usuarioId, @RequestParam Long opcaoId) {
            try {
            VotosResponseDTO votosDTO = votosService.registrarVoto(usuarioId, opcaoId);
            return new ResponseEntity<>(votosDTO, HttpStatus.CREATED);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/opcao/{opcaoId}")
    public List<Votos> listarVotos(@PathVariable Long opcaoId) {
        return votosService.listarPorOpcao(opcaoId);
    }
}
