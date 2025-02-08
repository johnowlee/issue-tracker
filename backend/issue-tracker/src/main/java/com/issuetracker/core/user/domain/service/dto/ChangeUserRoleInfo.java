package com.issuetracker.core.user.domain.service.dto;

import com.issuetracker.core.user.domain.model.UserRole;

public record ChangeUserRoleInfo(long adminId, long userId, UserRole role) {
}
