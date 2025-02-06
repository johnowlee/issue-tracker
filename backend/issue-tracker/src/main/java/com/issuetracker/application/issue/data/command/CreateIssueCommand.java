package com.issuetracker.application.issue.data.command;

import java.time.LocalDateTime;
import java.util.Set;

public record CreateIssueCommand(Long projectId,
                                 String title,
                                 String description,
                                 LocalDateTime startDateTime,
                                 LocalDateTime endDateTime,
                                 Set<Long> assigneeIds,
                                 Set<Long> labelIds) {
}
