package com.invoiceai.application.usecase;

import com.invoiceai.domain.model.User;

import java.util.UUID;

public interface GetUserUseCase {

    User getById(UUID id);
}