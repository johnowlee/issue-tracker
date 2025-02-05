package com.issuetracker.application.user.mapper;

import com.issuetracker.application.user.data.command.CreateUserCommand;
import com.issuetracker.core.user.domain.service.dto.CreateUserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserUseCaseMapper {
    public CreateUserInfo toUserCreateInfo(CreateUserCommand createUserCommand) {
        return new CreateUserInfo(createUserCommand.name(), createUserCommand.email(), createUserCommand.password());
    }
}
