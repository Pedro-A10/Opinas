package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.model.Votos;
import com.PedroA10.Opinas.service.OpcaoService;
import com.PedroA10.Opinas.service.VotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/votos")
public class VotosController {

    @Autowired
    private VotosService votosService;

    @PostMapping
        public ResponseEntity<Votos> votar(@RequestParam Long usuarioId, @RequestParam Long opcaoId) {
            try {
            Votos votos = votosService.registrarVoto(usuarioId, opcaoId);
            return new ResponseEntity<>(votos, HttpStatus.CREATED);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/opcao/{opcaoId}")
    public List<Votos> listarVotos(@PathVariable Long opcaoId) {
        return votosService.listarPorOpcao(opcaoId);
    }
}
