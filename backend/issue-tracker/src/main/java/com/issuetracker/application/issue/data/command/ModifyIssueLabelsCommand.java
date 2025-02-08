package com.issuetracker.application.issue.data.command;

import java.util.Set;

public record ModifyIssueLabelsCommand(long issueId, long userId, Set<Long> labelIds) {
}
