package com.PedroA10.Opinas.service;

import com.PedroA10.Opinas.dto.user.UserRequestDTO;
import com.PedroA10.Opinas.dto.user.UserResponseDTO;
import com.PedroA10.Opinas.mapper.UserMapper;
import com.PedroA10.Opinas.model.User;
import com.PedroA10.Opinas.repository.UserRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> findById(Long id){
        return userRepository.findById(id)
                .map(UserMapper::toDTO);
    }

    public UserResponseDTO createUser(@Valid UserRequestDTO userRequestDTO){
        if (userRequestDTO.getEmail().isEmpty()) {
            throw new IllegalArgumentException("Email required.");
        }

        User user = UserMapper.toModel(userRequestDTO);

        if (userRequestDTO.getPassword() == null || userRequestDTO.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Password required.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User save = userRepository.save(user);
        return UserMapper.toDTO(save);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User findEntityById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
