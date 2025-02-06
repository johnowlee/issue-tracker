package com.issuetracker.application.issue.data.command;

import java.time.LocalDate;
import java.util.Set;

public record CreateIssueCommand(Long projectId,
                                 String title,
                                 String description,
                                 LocalDate startDate,
                                 LocalDate endDate,
                                 Set<Long> assigneeIds,
                                 Set<Long> labelIds) {
}
