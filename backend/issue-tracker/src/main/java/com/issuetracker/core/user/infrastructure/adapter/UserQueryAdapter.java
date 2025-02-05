package com.issuetracker.core.user.infrastructure.adapter;

import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.port.UserQueryPort;
import com.issuetracker.core.user.infrastructure.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserQueryAdapter implements UserQueryPort {

    private final UserJpaRepository userJpaRepository;

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email);
    }
}
