package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.repository.EnqueteRepository;
import com.PedroA10.Opinas.repository.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquetes/{enqueteId}/opcoes")
public class OpcaoController {

    @Autowired
    private OpcaoRepository opcaoRepository;

    @Autowired
    private EnqueteRepository enqueteRepository;

    @PostMapping
    public ResponseEntity<Opcao> criarOpcoes(@PathVariable Long enqueteId ,@RequestBody Opcao opcao) {
        Enquete enquete = enqueteRepository.findById(enqueteId)
            .orElseThrow(() -> new RuntimeException("Enquete não encontrada"));
        opcao.setEnquete(enquete);
        Opcao novaOpcao= opcaoRepository.save(opcao);

        return new ResponseEntity<>(novaOpcao, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Opcao> listarOpcaoPorId(@PathVariable Long id) {

        if (!enqueteRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        List<Opcao> opcoes = opcaoRepository.findByEnqueteId(id);
        return ResponseEntity.ok((Opcao) opcoes);
    }
}
