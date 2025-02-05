package com.issuetracker.representer.project.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

public record CreateIssueResponse(
        long issueId,
        long projectId,
        String title,
        String description,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        Set<Long> assigneeIds,
        Set<Long> labelIds) {
}
