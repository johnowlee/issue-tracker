package com.issuetracker.application.user.usecase;

import com.issuetracker.application.user.data.command.CreateUserCommand;
import com.issuetracker.application.user.mapper.UserUseCaseMapper;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserCommandService userCommandService;
    private final UserUseCaseMapper userUseCaseMapper;

    public User execute(CreateUserCommand createUserCommand) {
        return userCommandService.createUser(userUseCaseMapper.toUserCreateInfo(createUserCommand));
    }
}
