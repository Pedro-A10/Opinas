package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.vote.VoteResponseDTO;
import com.PedroA10.Opinas.exception.OptionNotFoundException;
import com.PedroA10.Opinas.exception.UserNotFoundException;
import com.PedroA10.Opinas.mapper.VoteMapper;
import com.PedroA10.Opinas.model.Option;
import com.PedroA10.Opinas.model.User;
import com.PedroA10.Opinas.model.Vote;
import com.PedroA10.Opinas.repository.OptionRepository;
import com.PedroA10.Opinas.repository.UserRepository;
import com.PedroA10.Opinas.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private UserRepository userRepository;

    public VoteResponseDTO registerVote(Long userId, Long optionId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found."));
        Option option = optionRepository.findById(optionId)
                .orElseThrow(() -> new OptionNotFoundException("Option not found."));
        VoteResponseDTO voteDTO = new VoteResponseDTO(null, user.getId(), option.getId());

        Vote vote = VoteMapper.toModel(voteDTO, user, option);
        Vote save = voteRepository.save(vote);
        return VoteMapper.toDTO(save);
    }

    public List<Vote> listByOption(Long optionId) {
        return voteRepository.findByOptionId(optionId);
    }
}
