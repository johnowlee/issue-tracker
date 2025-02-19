package com.issuetracker.representer.issue.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public record ModifyIssueLabelsRequest(@NotBlank Long userId,  Set<Long> labelIds) {
}
