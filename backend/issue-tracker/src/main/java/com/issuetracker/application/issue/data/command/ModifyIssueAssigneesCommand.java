package com.issuetracker.application.issue.data.command;

import java.util.Set;

public record ModifyIssueAssigneesCommand(long id, Set<Long> assigneeIds) {
}
