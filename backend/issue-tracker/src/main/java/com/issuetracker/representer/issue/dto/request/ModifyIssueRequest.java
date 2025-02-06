package com.issuetracker.representer.issue.dto.request;

import java.time.LocalDateTime;

public record ModifyIssueRequest(
        String title,
        String description,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime) {
}
