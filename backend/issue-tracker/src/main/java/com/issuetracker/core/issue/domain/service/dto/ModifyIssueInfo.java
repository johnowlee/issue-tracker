package com.issuetracker.core.issue.domain.service.dto;

import java.time.LocalDate;

public record ModifyIssueInfo(
        Long id,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate) {
}
