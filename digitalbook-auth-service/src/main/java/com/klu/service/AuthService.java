package com.klu.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.klu.dto.LoginRequest;
import com.klu.dto.LoginResponse;
import com.klu.dto.RegisterRequest;
import com.klu.entity.User;
import com.klu.repository.UserRepository;
import com.klu.security.JwtService;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String register(RegisterRequest request) {

        User existingUser =
                userRepository.findByEmail(request.getEmail());

        if (existingUser != null) {

            return "Email already registered";
        }

        User user = new User();

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole("SUBSCRIBER");

        userRepository.save(user);

        return "User registered successfully";
    }

    public LoginResponse login(LoginRequest request) {

        User user =
                userRepository.findByEmail(request.getEmail());

        if (user == null) {

            throw new RuntimeException("User not found");
        }

        boolean passwordMatched =
                passwordEncoder.matches(
                    request.getPassword(),
                    user.getPassword()
                );

        if (!passwordMatched) {

            throw new RuntimeException("Invalid password");
        }

        String token =
                jwtService.generateToken(
                    user.getId(),
                    user.getEmail(),
                    user.getRole()
                );

        return new LoginResponse(
                token,
                "Login successful",
                user.getId(),
                user.getRole()
        );
    }
}