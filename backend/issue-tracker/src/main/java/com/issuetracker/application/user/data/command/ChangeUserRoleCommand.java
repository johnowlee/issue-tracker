package com.issuetracker.application.user.data.command;

import com.issuetracker.core.user.domain.model.UserRole;

public record ChangeUserRoleCommand(long adminId, long userId, UserRole role) {
}