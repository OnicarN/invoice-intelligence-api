package com.invoiceai.application.usecase;

import com.invoiceai.domain.model.User;

public interface LoginUseCase {

    String login(User user);
}