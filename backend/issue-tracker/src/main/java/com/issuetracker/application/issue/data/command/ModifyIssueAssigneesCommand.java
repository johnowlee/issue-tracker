package com.issuetracker.application.issue.data.command;

import java.util.Set;

public record ModifyIssueAssigneesCommand(long issueId, long userId, Set<Long> assigneeIds) {
}
