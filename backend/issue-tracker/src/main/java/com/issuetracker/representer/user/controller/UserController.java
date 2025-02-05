package com.issuetracker.representer.user.controller;

import com.issuetracker.application.user.usecase.CreateUserUseCase;
import com.issuetracker.application.user.usecase.GetUserUseCase;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.representer.user.mapper.UserControllerMapper;
import com.issuetracker.representer.user.dto.request.CreateUserRequest;
import com.issuetracker.representer.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final UserControllerMapper mapper;

    @PostMapping("/users")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = createUserUseCase.execute(mapper.toCreateUserCommand(request));
        return ResponseEntity.ok().body(mapper.toUserResponse(user));
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> fetchUser(@PathVariable long id) {
        User user = getUserUseCase.execute(mapper.toGetUserQuery(id));
        return ResponseEntity.ok().body(mapper.toUserResponse(user));
    }
}