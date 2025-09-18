package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.UsuarioDTO;
import com.PedroA10.Opinas.mapper.UsuarioMapper;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.repository.UsuarioRepository;

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


    public List<UsuarioDTO> findAll() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper ::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> findById(Long id){
        return usuarioRepository.findById(id)
                .map(UsuarioMapper ::toDTO);
    }

    public UsuarioDTO criarUsuario(UsuarioDTO usuarioDTO){
        if (usuarioDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("E-mail obrigatório.");
        }

        Usuario usuario = UsuarioMapper.toEntity(usuarioDTO);

        if (usuario.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Senha obrigatória.");
        }

        String senhaCriptografada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        Usuario save =usuarioRepository.save(usuario);
        return UsuarioMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }
}
