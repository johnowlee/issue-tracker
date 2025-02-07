package com.issuetracker.representer.issue.dto.request;

import com.issuetracker.core.issue.domain.model.IssueStatus;
import jakarta.validation.constraints.NotBlank;

public record ChangeIssueStatusRequest(@NotBlank IssueStatus status) {
}
