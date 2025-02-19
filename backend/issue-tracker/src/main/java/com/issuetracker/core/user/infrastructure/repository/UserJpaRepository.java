package com.issuetracker.core.user.infrastructure.repository;

import com.issuetracker.core.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
