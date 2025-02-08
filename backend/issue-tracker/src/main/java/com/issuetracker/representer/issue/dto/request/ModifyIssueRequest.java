package com.issuetracker.representer.issue.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record ModifyIssueRequest(
        @NotBlank
        Long userId,
        @NotBlank
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate) {
}
