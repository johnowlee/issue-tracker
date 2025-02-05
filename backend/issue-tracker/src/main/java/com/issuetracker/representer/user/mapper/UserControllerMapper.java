package com.issuetracker.representer.user.mapper;

import com.issuetracker.application.user.data.command.CreateUserCommand;
import com.issuetracker.application.user.data.query.GetUserQuery;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.representer.user.dto.request.CreateUserRequest;
import com.issuetracker.representer.user.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserControllerMapper {

    public CreateUserCommand toCreateUserCommand(CreateUserRequest createUserRequest) {
        return new CreateUserCommand(createUserRequest.name(), createUserRequest.email(), createUserRequest.password());
    }

    public UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public GetUserQuery toGetUserQuery(long id) {
        return new GetUserQuery(id);
    }
}
