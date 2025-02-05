package com.issuetracker.core.project.domain.service.dto;

import java.time.LocalDateTime;
import java.util.Set;

public record CreateIssueInfo(Long projectId,
                              String title,
                              String description,
                              LocalDateTime startDateTime,
                              LocalDateTime endDateTime,
                              Set<Long> assigneeIds,
                              Set<Long> labelIds) {
}
