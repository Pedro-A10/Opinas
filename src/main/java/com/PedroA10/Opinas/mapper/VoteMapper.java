package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.model.Option;
import com.PedroA10.Opinas.dto.vote.VoteResponseDTO;
import com.PedroA10.Opinas.model.User;
import com.PedroA10.Opinas.model.Vote;

public class VoteMapper {

    public static Vote toModel(VoteResponseDTO dto, User user, Option option) {
        Vote vote = new Vote();
        vote.setUser(user);
        vote.setOption(option);
        return vote;
    }

    public static VoteResponseDTO toDTO (Vote vote) {
        return new VoteResponseDTO(
                vote.getId(),
                vote.getUser().getId(),
                vote.getOption().getId()
        );
    }
}