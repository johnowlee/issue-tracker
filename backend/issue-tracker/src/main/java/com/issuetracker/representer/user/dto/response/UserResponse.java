package com.issuetracker.representer.user.dto.response;

import com.issuetracker.core.user.domain.model.UserRole;

public record UserResponse(long id, String name, String email, UserRole role) {
}