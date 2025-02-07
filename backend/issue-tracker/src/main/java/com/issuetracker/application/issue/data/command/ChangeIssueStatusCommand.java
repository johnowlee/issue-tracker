package com.issuetracker.application.issue.data.command;

import com.issuetracker.core.issue.domain.model.IssueStatus;

public record ChangeIssueStatusCommand(long id, IssueStatus status) {
}
