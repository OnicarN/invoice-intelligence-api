package com.invoiceai.presentation.controller;

import com.invoiceai.application.usecase.LoginUseCase;
import com.invoiceai.domain.model.User;
import com.invoiceai.presentation.dto.LoginRequest;
import com.invoiceai.presentation.dto.LoginResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request
    ) {

        User user = new User(
                null,
                request.getPassword(),
                request.getEmail()
        );

        String token = loginUseCase.login(user);

        return ResponseEntity.ok(new LoginResponse(token));
    }
}