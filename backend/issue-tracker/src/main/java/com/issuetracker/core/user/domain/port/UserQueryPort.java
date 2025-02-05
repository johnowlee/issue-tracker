package com.issuetracker.core.user.domain.port;

import com.issuetracker.core.user.domain.model.User;

import java.util.Optional;

public interface UserQueryPort {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
