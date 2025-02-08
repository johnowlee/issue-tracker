package com.issuetracker.representer.label.dto.request;

import jakarta.validation.constraints.NotBlank;

public record ModifyLabelRequest(@NotBlank String name, @NotBlank Long userId) {
}
