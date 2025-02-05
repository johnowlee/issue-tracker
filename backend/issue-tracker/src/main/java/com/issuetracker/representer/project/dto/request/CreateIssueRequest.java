package com.issuetracker.representer.project.dto.request;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.Set;

public record CreateIssueRequest(

        @NotBlank
        String title,

        String description,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime,
        Set<Long> assigneeIds,
        Set<Long> labelIds) {
}
