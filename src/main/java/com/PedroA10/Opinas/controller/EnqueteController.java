package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.model.Enquete;
import com.PedroA10.Opinas.repository.EnqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquetes")
public class EnqueteController {

    @Autowired
    private EnqueteRepository enqueteRepository;

    @GetMapping
    public List<Enquete> listarEnquetes(){
        return enqueteRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Enquete> criarEnquete(@RequestBody Enquete enquete) {
        Enquete novaEnquete = new Enquete();
        return new ResponseEntity<>(novaEnquete, HttpStatus.CREATED);
    }
}
