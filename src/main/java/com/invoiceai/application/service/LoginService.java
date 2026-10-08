package com.invoiceai.application.service;

import com.invoiceai.application.usecase.LoginUseCase;
import com.invoiceai.domain.model.User;
import com.invoiceai.domain.port.UserRepository;
import com.invoiceai.infrastucture.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @Override
    public String login(User user) {

        User existingUser = userRepository
                .findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        boolean passwordMatches = passwordEncoder.matches(
                user.getPassword(),
                existingUser.getPassword()
        );

        if (!passwordMatches) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(
                existingUser.getId(),
                existingUser.getEmail()
        );
    }
}