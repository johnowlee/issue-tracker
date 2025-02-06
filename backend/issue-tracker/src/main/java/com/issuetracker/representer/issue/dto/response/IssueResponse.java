package com.issuetracker.representer.issue.dto.response;

import com.issuetracker.core.issue.domain.model.IssueStatus;

import java.time.LocalDate;

public record IssueResponse(
        long id,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        IssueStatus issueStatus) {
}
