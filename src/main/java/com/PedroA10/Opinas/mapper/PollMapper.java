package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.poll.PollRequestDTO;
import com.PedroA10.Opinas.dto.poll.PollResponseDTO;
import com.PedroA10.Opinas.dto.option.OptionResponseDTO;
import com.PedroA10.Opinas.dto.user.UserResponseDTO;
import com.PedroA10.Opinas.model.Poll;
import com.PedroA10.Opinas.model.Option;
import com.PedroA10.Opinas.model.User;

public class PollMapper {

    public static PollResponseDTO toDTO(Poll poll) {
        PollResponseDTO dto = new PollResponseDTO();
        dto.setId(poll.getId());
        dto.setTitle(poll.getTitle());
        dto.setMessage(poll.getMessage());

        UserResponseDTO userDTO = new UserResponseDTO();
        userDTO.setId(poll.getUser().getId());
        userDTO.setName(poll.getUser().getName());
        userDTO.setEmail(poll.getUser().getEmail());
        dto.setUser(userDTO);

        if (poll.getOptions() != null) {
            dto.setOptions(
                    poll.getOptions().stream()
                            .map(option -> {
                                return new OptionResponseDTO(option.getId(), option.getText());
                            })
                            .toList()
            );
        }

        return dto;
    }

    public static Poll toModel (PollRequestDTO dto, User user) {
        Poll poll = new Poll();
        poll.setTitle(dto.getTitle());
        poll.setMessage(dto.getMessage());
        poll.setUser(user);

        if (dto.getOption() != null) {
            dto.getOption().forEach(optionDTO -> {
                Option option = new Option();
                option.setText(optionDTO.getText());
                option.setPoll(poll);
                poll.getOptions().add(option);
            });
        }

        return poll;
    }
}
