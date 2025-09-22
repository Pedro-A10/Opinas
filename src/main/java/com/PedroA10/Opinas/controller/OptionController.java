package com.PedroA10.Opinas.controller;

import com.PedroA10.Opinas.dto.option.OptionRequestDTO;
import com.PedroA10.Opinas.dto.option.OptionResponseDTO;
import com.PedroA10.Opinas.model.Option;
import com.PedroA10.Opinas.service.PollService;
import com.PedroA10.Opinas.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls/{pollId}/options")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @Autowired
    private PollService pollService;

    @PostMapping
    public ResponseEntity<OptionResponseDTO> createOption(@PathVariable Long pollId, @RequestBody OptionRequestDTO optionDTO) {
        try {
            OptionResponseDTO newOption = optionService.createOption(pollId, optionDTO);
            return new ResponseEntity<>(newOption, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public List<Option> listOptionById(@PathVariable Long pollId) {
        return optionService.findByPollId(pollId);

    }
}
