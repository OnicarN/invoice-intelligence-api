package com.invoiceai.application.usecase;

import com.invoiceai.domain.model.User;

public interface CreateUserUseCase {

    User create(User user);
}