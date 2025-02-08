package com.issuetracker.representer.project.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ModifyProjectRequest(@NotBlank Long userId, @NotBlank String title, String description) {
}
