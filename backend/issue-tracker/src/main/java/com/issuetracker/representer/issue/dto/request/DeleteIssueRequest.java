package com.issuetracker.representer.issue.dto.request;

import jakarta.validation.constraints.NotBlank;

public record DeleteIssueRequest(@NotBlank Long userId) {
}
