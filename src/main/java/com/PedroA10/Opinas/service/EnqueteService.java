package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.repository.EnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnqueteService {

    @Autowired
    private EnqueteRepository enqueteRepository;

    public List<Enquete> findAll() {
        return enqueteRepository.findAll();
    }

    public Optional<Enquete> findById(Long id) {
        return enqueteRepository.findById(id);
    }

    public Enquete criarEnquete(Enquete enquete) {
        if (enquete.getTitulo().isEmpty()){
            throw new IllegalArgumentException("É necessário ter um titulo");
        }
        if (enquete.getMensagem().isEmpty()){
            throw new IllegalArgumentException("É necessário ter uma mensagem na enquete.");
        }
        enquete.getOpcoes().forEach(opcao -> opcao.setEnquete(enquete));
        return enqueteRepository.save(enquete);
    }

    public void deleteById(Long id) {
        enqueteRepository.deleteById(id);
    }
}
