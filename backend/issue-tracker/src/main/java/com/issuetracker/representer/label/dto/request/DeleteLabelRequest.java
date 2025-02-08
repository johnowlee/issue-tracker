package com.issuetracker.representer.label.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DeleteLabelRequest(@NotBlank Long userId) {
}
