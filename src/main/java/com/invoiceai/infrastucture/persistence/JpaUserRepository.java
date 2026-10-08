package com.invoiceai.infrastucture.persistence;

import com.invoiceai.domain.model.User;
import com.invoiceai.domain.port.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class JpaUserRepository implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public JpaUserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public User save(User user) {

        UserEntity entity = new UserEntity();

        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());

        UserEntity savedEntity = userJpaRepository.save(entity);

        return new User(
                savedEntity.getId(),
                savedEntity.getPassword(),
                savedEntity.getEmail()
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return userJpaRepository.findByEmail(email)
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getPassword(),
                        userEntity.getEmail()
                ));
    }

    @Override
    public Optional<User> findById(UUID id) {

        return userJpaRepository.findById(id)
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getPassword(),
                        userEntity.getEmail()
                ));
    }
}