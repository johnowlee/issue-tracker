package com.issuetracker.representer.user.dto.request;

import com.issuetracker.core.user.domain.model.UserRole;
import jakarta.validation.constraints.NotBlank;

public record ChangeRoleRequest(@NotBlank Long adminId, @NotBlank UserRole role) {
}
