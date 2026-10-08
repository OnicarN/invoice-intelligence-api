package com.invoiceai.presentation.controller;

import com.invoiceai.application.usecase.CreateUserUseCase;
import com.invoiceai.application.usecase.GetUserUseCase;
import com.invoiceai.domain.model.User;
import com.invoiceai.presentation.dto.CreateUserRequest;
import com.invoiceai.presentation.dto.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(
            CreateUserUseCase createUserUseCase,
            GetUserUseCase getUserUseCase
    ) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody CreateUserRequest request
    ) {

        User user = new User(
                null,
                request.getPassword(),
                request.getEmail()
        );

        User createdUser = createUserUseCase.create(user);

        UserResponse response = new UserResponse(
                createdUser.getId(),
                createdUser.getEmail()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {

        User user = getUserUseCase.getById(id);

        UserResponse response = new UserResponse(
                user.getId(),
                user.getEmail()
        );

        return ResponseEntity.ok(response);
    }
}