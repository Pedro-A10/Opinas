package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.vote.VoteResponseDTO;
import com.PedroA10.Opinas.model.Vote;
import com.PedroA10.Opinas.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
        public ResponseEntity<VoteResponseDTO> vote(@RequestParam Long userId, @RequestParam Long optionId) {
            try {
            VoteResponseDTO votesDTO = voteService.registerVote(userId, optionId);
            return new ResponseEntity<>(votesDTO, HttpStatus.CREATED);
        }catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/option/{optionId}")
    public List<Vote> listVote(@PathVariable Long optionId) {
        return voteService.listByOption(optionId);
    }
}
