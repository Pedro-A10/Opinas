package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.UsuarioDTO;
import com.PedroA10.Opinas.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDTO> listarUsuario() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> listarUsuarioPorId(@PathVariable Long id){
       return usuarioService.findById(id)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        try {
            UsuarioDTO novoUsuariuo = usuarioService.criarUsuario(usuarioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuariuo);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        try {
            usuarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
