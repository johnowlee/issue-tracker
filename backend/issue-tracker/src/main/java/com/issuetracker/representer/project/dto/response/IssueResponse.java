package com.issuetracker.representer.project.dto.response;

import com.issuetracker.core.project.domain.model.IssueStatus;

import java.time.LocalDateTime;

public record IssueResponse(
        long id,
        String title,
        String description,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        IssueStatus issueStatus) {
}
