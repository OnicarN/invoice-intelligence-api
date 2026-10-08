package com.invoiceai.domain.port;

import com.invoiceai.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
     User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(UUID id);
}
