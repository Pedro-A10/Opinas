package com.PedroA10.Opinas.service;

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

    public Opcao criarOpcao(Long enqueteId, Opcao opcao)  {
        Enquete enquete = enqueteRepository.findById(enqueteId)
                .orElseThrow(() -> new IllegalArgumentException("Enquete não encontrada."));
        opcao.setEnquete(enquete);

        return opcaoRepository.save(opcao);
    }

    public List<Opcao> findByEnqueteId(Long enqueteId){
        return opcaoRepository.findByEnqueteId(enqueteId);
    }
}
