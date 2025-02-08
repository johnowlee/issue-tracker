package com.issuetracker.representer.issue.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record ModifyIssueAssigneesRequest(@NotBlank Long userId, Set<Long> assigneeIds) {
}
