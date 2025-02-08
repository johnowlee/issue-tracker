package com.issuetracker.application.issue.data.command;

import java.time.LocalDate;

public record ModifyIssueCommand(
        long issueId,
        long userId,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate) {
}
