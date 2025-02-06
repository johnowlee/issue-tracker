package com.issuetracker.core.issue.domain.service.dto;

import java.time.LocalDate;
import java.util.Set;

public record CreateIssueInfo(Long projectId,
                              String title,
                              String description,
                              LocalDate startDate,
                              LocalDate endDate,
                              Set<Long> assigneeIds,
                              Set<Long> labelIds) {
}
