package com.issuetracker.application.issue.data.command;

import java.util.Set;

public record ModifyIssueLabelsCommand(long id, Set<Long> labelIds) {
}
