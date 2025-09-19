package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.opcao.OpcaoRequestDTO;
import com.PedroA10.Opinas.dto.opcao.OpcaoResponseDTO;
import com.PedroA10.Opinas.mapper.OpcaoMapper;
import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.repository.EnqueteRepository;
import com.PedroA10.Opinas.repository.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcaoService {

    @Autowired
    private OpcaoRepository opcaoRepository;

    @Autowired
    private EnqueteRepository enqueteRepository;

    public OpcaoResponseDTO criarOpcao(Long enqueteId, OpcaoRequestDTO opcaoRequestDTO)  {
        Enquete enquete = enqueteRepository.findById(enqueteId)
                .orElseThrow(() -> new IllegalArgumentException("Enquete não encontrada."));

        Opcao opcao = OpcaoMapper.toModel(opcaoRequestDTO);
        Opcao save = opcaoRepository.save(opcao);
        return OpcaoMapper.toDTO(save);
    }

    public List<Opcao> findByEnqueteId(Long enqueteId){
        return opcaoRepository.findByEnqueteId(enqueteId);
    }
}
