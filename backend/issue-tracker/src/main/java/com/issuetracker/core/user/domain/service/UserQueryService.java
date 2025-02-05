package com.issuetracker.core.user.domain.service;

import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.port.UserQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQueryService {

    private final UserQueryPort userQueryPort;

    // TODO: 2025-02-05 예외처리 리팩토링
    public User getUserById(long id) {
        return userQueryPort.findById(id)
                .orElseThrow(IllegalStateException::new);
    }

    public User getUserByEmail(String email) {
        return userQueryPort.findByEmail(email)
                .orElseThrow(IllegalStateException::new);
    }

    public boolean isPresentByEmail(String email) {
        return userQueryPort.findByEmail(email).isPresent();
    }
}