package com.issuetracker.representer.label.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateLabelRequest(@NotBlank String name) {
}
