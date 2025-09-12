package com.PedroA10.Opinas.service;


import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.model.Votos;
import com.PedroA10.Opinas.repository.OpcaoRepository;
import com.PedroA10.Opinas.repository.UsuarioRepository;
import com.PedroA10.Opinas.repository.VotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotosService {

    @Autowired
    private VotosRepository votosRepository;

    @Autowired
    private OpcaoRepository opcaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Votos registrarVoto(Long usuarioId, Long opcaoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        Opcao opcao = opcaoRepository.findById(opcaoId)
                .orElseThrow(() -> new IllegalArgumentException("Opção não encontrada"));
        Votos votos = new Votos();
        votos.setUsuario(usuario);
        votos.setOpcao(opcao);

        return votosRepository.save(votos);
    }

    public List<Votos> listarPorOpcao(Long opcaoId) {
        return votosRepository.findByOpcaoId(opcaoId);
    }
}
