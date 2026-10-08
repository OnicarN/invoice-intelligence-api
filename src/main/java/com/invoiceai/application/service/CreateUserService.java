package com.invoiceai.application.service;

import com.invoiceai.application.usecase.CreateUserUseCase;
import com.invoiceai.domain.model.User;
import com.invoiceai.domain.port.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateUserService implements CreateUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());

        User userToSave = new User(
                UUID.randomUUID(),
                encodedPassword,
                user.getEmail()
        );

        return userRepository.save(userToSave);
    }
}