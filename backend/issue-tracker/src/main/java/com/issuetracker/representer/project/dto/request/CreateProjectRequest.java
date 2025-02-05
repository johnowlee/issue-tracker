package com.issuetracker.representer.project.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateProjectRequest(
        @NotBlank
        Long managerId,

        @NotBlank
        String title,

        String description) {
}
