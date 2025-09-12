package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Usuario;

import com.PedroA10.Opinas.service.EnqueteService;
import com.PedroA10.Opinas.service.UsuarioService;
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
    public List<Enquete> listarEnquetes(){
        return enqueteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enquete> listarEnquetesPorId(@PathVariable Long id){
         return enqueteService.findById(id)
                 .map(ResponseEntity::ok)
                 .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Enquete> criarEnquete(@RequestBody Enquete enquete) {
        Usuario usuario = usuarioService.findById(enquete.getUsuario().getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        enquete.setUsuario(usuario);

        Enquete novaEnquete = enqueteService.criarEnquete(enquete);
        return new ResponseEntity<>(novaEnquete, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnquete(@PathVariable Long id) {
        enqueteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
