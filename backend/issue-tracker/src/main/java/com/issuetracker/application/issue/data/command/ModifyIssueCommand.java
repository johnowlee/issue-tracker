package com.issuetracker.application.issue.data.command;

import java.time.LocalDate;

public record ModifyIssueCommand(
        Long id,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate) {
}
