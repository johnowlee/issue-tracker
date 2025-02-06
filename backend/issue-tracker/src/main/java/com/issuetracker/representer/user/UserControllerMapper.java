package com.issuetracker.representer.user;

import com.issuetracker.application.user.data.command.CreateUserCommand;
import com.issuetracker.representer.common.CommonControllerMapper;
import com.issuetracker.representer.user.dto.request.CreateUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserControllerMapper extends CommonControllerMapper {

    public CreateUserCommand toCreateUserCommand(CreateUserRequest createUserRequest) {
        return new CreateUserCommand(createUserRequest.name(), createUserRequest.email(), createUserRequest.password());
    }
}
