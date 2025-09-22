package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.poll.PollRequestDTO;
import com.PedroA10.Opinas.dto.poll.PollResponseDTO;

import com.PedroA10.Opinas.model.User;
import com.PedroA10.Opinas.service.PollService;
import com.PedroA10.Opinas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
public class PollController {

    @Autowired
    private PollService pollService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<PollResponseDTO> listPolls() {
        return pollService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PollResponseDTO> listPollsById(@PathVariable Long id) {
        return pollService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PollResponseDTO> createPoll(@RequestBody @Valid PollRequestDTO pollRequestDTO) {
        User user = userService.findEntityById(pollRequestDTO.getUserId());
        PollResponseDTO newPoll = pollService.createPoll(pollRequestDTO, user);
        return new ResponseEntity<>(newPoll, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoll(@PathVariable Long id) {
        try {
            pollService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}