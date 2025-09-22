package com.PedroA10.Opinas.mapper;

import com.PedroA10.Opinas.dto.user.UserRequestDTO;
import com.PedroA10.Opinas.dto.user.UserResponseDTO;
import com.PedroA10.Opinas.model.User;
import jakarta.validation.Valid;

public class UserMapper {

    public static UserResponseDTO toDTO (User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

    public static User toModel (@Valid UserRequestDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
