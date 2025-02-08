package com.issuetracker.representer.project.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DeleteProjectRequest(@NotBlank Long userId) {
}
