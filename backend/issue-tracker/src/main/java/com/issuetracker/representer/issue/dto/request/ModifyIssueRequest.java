package com.issuetracker.representer.issue.dto.request;

import java.time.LocalDate;

public record ModifyIssueRequest(
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate) {
}
