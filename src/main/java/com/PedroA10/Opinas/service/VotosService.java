package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.votos.VotosResponseDTO;
import com.PedroA10.Opinas.mapper.VotosMapper;
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

    public VotosResponseDTO registrarVoto(Long usuarioId, Long opcaoId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        Opcao opcao = opcaoRepository.findById(opcaoId)
                .orElseThrow(() -> new IllegalArgumentException("Opção não encontrada"));
        VotosResponseDTO votosDTO = new VotosResponseDTO(null, usuario.getId(), opcao.getId());

        Votos votos = VotosMapper.toModel(votosDTO, usuario, opcao);
        Votos save = votosRepository.save(votos);
        return VotosMapper.toDTO(save);
    }

    public List<Votos> listarPorOpcao(Long opcaoId) {
        return votosRepository.findByOpcaoId(opcaoId);
    }
}
