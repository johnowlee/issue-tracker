package com.issuetracker.application.user.usecase;

import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetUserUseCase {

    private final UserQueryService userQueryService;
    public User execute(long id) {
        return userQueryService.getUserById(id);
    }
}
