package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.repository.EnqueteRepository;
import com.PedroA10.Opinas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enquetes")
public class EnqueteController {

    @Autowired
    private EnqueteRepository enqueteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Enquete> listarEnquetes(){
        return enqueteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enquete> listarEnquetesPorId(@PathVariable Long id){
         Optional<Enquete> enqueteRepositoryById = enqueteRepository.findById(id);

         if (enqueteRepositoryById.isPresent()){
             return ResponseEntity.ok(enqueteRepositoryById.get());
         }else {
             return ResponseEntity.notFound().build();
         }
    }

    @PostMapping
    public ResponseEntity<Enquete> criarEnquete(@RequestBody Enquete enquete) {
        Usuario usuario = usuarioRepository.findById(1L).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        enquete.setUsuario(usuario);

        Enquete novaEnquete = enqueteRepository.save(enquete);
        return new ResponseEntity<>(novaEnquete, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEnquete(@PathVariable Long id) {
        Optional<Enquete> enqueteExistente = enqueteRepository.findById(id);

        if (enqueteExistente.isPresent()) {
            enqueteRepository.delete(enqueteExistente.get());
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.notFound().build();
    }
}
