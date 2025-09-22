package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.option.OptionRequestDTO;
import com.PedroA10.Opinas.dto.option.OptionResponseDTO;
import com.PedroA10.Opinas.mapper.OptionMapper;
import com.PedroA10.Opinas.model.Poll;
import com.PedroA10.Opinas.model.Option;
import com.PedroA10.Opinas.repository.PollRepository;
import com.PedroA10.Opinas.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private PollRepository pollRepository;

    public OptionResponseDTO createOption(Long pollId, OptionRequestDTO optionRequestDTO)  {
        Poll poll = pollRepository.findById(pollId)
                .orElseThrow(() -> new IllegalArgumentException("Poll not found."));

        Option option = OptionMapper.toModel(optionRequestDTO);
        Option save = optionRepository.save(option);
        return OptionMapper.toDTO(save);
    }

    public List<Option> findByPollId(Long pollId){
        return optionRepository.findByPollId(pollId);
    }
}
