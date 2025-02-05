package com.issuetracker.representer.user.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequest(
        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String password) {
}
