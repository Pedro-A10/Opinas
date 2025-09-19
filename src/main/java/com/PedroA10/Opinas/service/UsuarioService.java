package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.usuario.UsuarioRequestDTO;
import com.PedroA10.Opinas.dto.usuario.UsuarioResponseDTO;
import com.PedroA10.Opinas.mapper.UsuarioMapper;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.repository.UsuarioRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<UsuarioResponseDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper ::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> findById(Long id){
        return usuarioRepository.findById(id)
                .map(UsuarioMapper ::toDTO);
    }

    public UsuarioResponseDTO criarUsuario(@Valid UsuarioRequestDTO usuarioRequestDTO){
        if (usuarioRequestDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("E-mail obrigatório.");
        }

        Usuario usuario = UsuarioMapper.toModel(usuarioRequestDTO);

        if (usuarioRequestDTO.getPassword() == null ||usuarioRequestDTO.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Senha obrigatória.");
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Usuario save = usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario findEntityById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }
}
