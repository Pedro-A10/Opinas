package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> ListarUsuario() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario novoUsuariuo = new Usuario();
        return new ResponseEntity<>(novoUsuariuo, HttpStatus.CREATED);

    }
}
