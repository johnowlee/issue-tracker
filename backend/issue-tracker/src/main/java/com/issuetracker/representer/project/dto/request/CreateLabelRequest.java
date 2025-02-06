package com.issuetracker.representer.project.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateLabelRequest(@NotBlank String name) {
}
