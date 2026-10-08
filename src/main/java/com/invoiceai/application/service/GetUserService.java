package com.invoiceai.application.service;

import com.invoiceai.application.usecase.GetUserUseCase;
import com.invoiceai.domain.exception.UserNotFoundException;
import com.invoiceai.domain.model.User;
import com.invoiceai.domain.port.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetUserService implements GetUserUseCase {

    private final UserRepository userRepository;

    public GetUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}