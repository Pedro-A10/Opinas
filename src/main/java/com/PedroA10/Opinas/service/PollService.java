package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.poll.PollRequestDTO;
import com.PedroA10.Opinas.dto.poll.PollResponseDTO;
import com.PedroA10.Opinas.mapper.PollMapper;
import com.PedroA10.Opinas.model.Poll;
import com.PedroA10.Opinas.model.User;
import com.PedroA10.Opinas.repository.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PollService {

    @Autowired
    private PollRepository pollRepository;

    public List<PollResponseDTO> findAll() {
        return pollRepository.findAll()
                .stream()
                .map(PollMapper:: toDTO)
                .collect(Collectors.toList());
    }

    public Optional<PollResponseDTO> findById(Long id) {
        return pollRepository.findById(id)
                .map(PollMapper:: toDTO);
    }

    public PollResponseDTO createPoll(PollRequestDTO pollRequestDTO, User user) {
        if (pollRequestDTO.getTitle().isEmpty()){
            throw new IllegalArgumentException("It is necessary to have a title");
        }

        Poll poll = PollMapper.toModel(pollRequestDTO, user);

        if (pollRequestDTO.getMessage().isEmpty()){
            throw new IllegalArgumentException("A description is required in the poll.");
        }
        if (poll.getOptions() != null) {
            poll.getOptions().forEach(option-> option.setPoll(poll));
        }

        Poll save = pollRepository.save(poll);
        return PollMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        pollRepository.deleteById(id);
    }
}
