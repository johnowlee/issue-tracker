package com.issuetracker.core.issue.domain.service.dto;

import com.issuetracker.core.issue.domain.model.IssueStatus;

public record ChangeIssueStatusInfo(long id, IssueStatus status) {
}
