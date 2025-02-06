package com.issuetracker.representer.issue.dto.response;

import com.issuetracker.core.issue.domain.model.IssueStatus;

import java.time.LocalDateTime;

public record IssueResponse(
        long id,
        String title,
        String description,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        IssueStatus issueStatus) {
}
