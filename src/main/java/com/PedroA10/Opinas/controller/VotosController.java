package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Opcao;
import com.PedroA10.Opinas.model.Votos;
import com.PedroA10.Opinas.repository.OpcaoRepository;
import com.PedroA10.Opinas.repository.VotosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/opcoes/{id}/votos")
public class VotosController {

    @Autowired
    private VotosRepository votosRepository;

    @Autowired
    private OpcaoRepository opcaoRepository;

    @PostMapping
    public ResponseEntity<Votos> registrarVotos(@PathVariable Long id) {
       Optional<Opcao> opcao = opcaoRepository.findById(id);
       if (opcao.isEmpty()) {
           return ResponseEntity.notFound().build();
       }

       Votos voto = new Votos();
       voto.setOpcao(opcao.get());
       Votos salvo = votosRepository.save(voto);

       return  ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Votos>> listarVotos(@PathVariable Long id) {
        Optional<Opcao> opcao = opcaoRepository.findById(id);

        if (opcao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<Votos> votos = votosRepository.findByOpcaoId(id);
        return ResponseEntity.ok(votos);
    }

    @GetMapping("/contar")
    public ResponseEntity<Long> contarVotos(@PathVariable Long id) {
        if (!opcaoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        Long total =votosRepository.countByOpcaoId(id);
        return ResponseEntity.ok(total);
    }

}
