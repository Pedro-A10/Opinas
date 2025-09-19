package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.opcao.OpcaoRequestDTO;
import com.PedroA10.Opinas.dto.opcao.OpcaoResponseDTO;
import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.service.EnqueteService;
import com.PedroA10.Opinas.service.OpcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquetes/{enqueteId}/opcoes")
public class OpcaoController {

    @Autowired
    private OpcaoService opcaoService;

    @Autowired
    private EnqueteService enqueteService;

    @PostMapping
    public ResponseEntity<OpcaoResponseDTO> criarOpcoes(@PathVariable Long enqueteId, @RequestBody OpcaoRequestDTO opcaoDTO) {
        try {
            OpcaoResponseDTO novaOpcao = opcaoService.criarOpcao(enqueteId, opcaoDTO);
            return new ResponseEntity<>(novaOpcao, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Opcao> listarOpcaoPorId(@PathVariable Long enqueteId) {
        return opcaoService.findByEnqueteId(enqueteId);

    }
}
