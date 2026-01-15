package com.fitnessApp.userservice.service;

import com.fitnessApp.userservice.dto.RegisterRequest;
import com.fitnessApp.userservice.entity.Name;
import com.fitnessApp.userservice.entity.User;
import com.fitnessApp.userservice.repository.UserRepository;
import com.fitnessApp.userservice.response.AuthResponse;
import com.fitnessApp.userservice.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public AuthResponse register(RegisterRequest request) {
        log.info("Registering new user with username: {}", request.getUsername());


        // Create new user
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        Name name = new Name();

        name.setFirstName(request.getFirstName());
        name.setLastName(request.getLastName());

        user.setName(name);
        user.setPhoneNumber(request.getPhoneNumber());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setGender(request.getGender());


        // Save user
        User savedUser = userRepository.save(user);
        log.info("User registered successfully with ID: {}", savedUser.getUserId());

        return AuthResponse.builder()
                .userId(savedUser.getUserId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .build();

    }
}
