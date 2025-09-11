package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarUsuarioPorId(@PathVariable Long id){
        Optional<Usuario> usuarioRepositoryById = usuarioRepository.findById(id);

        if (usuarioRepositoryById.isPresent()){
            return ResponseEntity.ok(usuarioRepositoryById.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuariuo = usuarioRepository.save(usuario);
        return new ResponseEntity<>(novoUsuariuo, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(id);

        if (usuarioExistente.isPresent()) {
            usuarioRepository.delete(usuarioExistente.get());
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.notFound().build();
    }
}
