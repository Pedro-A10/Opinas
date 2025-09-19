package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.enquete.EnqueteRequestDTO;
import com.PedroA10.Opinas.dto.enquete.EnqueteResponseDTO;
import com.PedroA10.Opinas.mapper.EnqueteMapper;
import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Usuario;
import com.PedroA10.Opinas.repository.EnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnqueteService {

    @Autowired
    private EnqueteRepository enqueteRepository;

    public List<EnqueteResponseDTO> findAll() {
        return enqueteRepository.findAll()
                .stream()
                .map(EnqueteMapper:: toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EnqueteResponseDTO> findById(Long id) {
        return enqueteRepository.findById(id)
                .map(EnqueteMapper :: toDTO);
    }

    public EnqueteResponseDTO criarEnquete(EnqueteRequestDTO enqueteRequestDTO, Usuario usuario) {
        if (enqueteRequestDTO.getTitulo().isEmpty()){
            throw new IllegalArgumentException("É necessário ter um titulo");
        }

        Enquete enquete = EnqueteMapper.toModel(enqueteRequestDTO, usuario);

        if (enqueteRequestDTO.getMensagem().isEmpty()){
            throw new IllegalArgumentException("É necessário ter uma descrição na enquete.");
        }
        if (enquete.getOpcoes() != null) {
            enquete.getOpcoes().forEach(opcao -> opcao.setEnquete(enquete));
        }

        Enquete save = enqueteRepository.save(enquete);
        return EnqueteMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        enqueteRepository.deleteById(id);
    }
}
