package com.issuetracker.representer.issue.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.Set;

public record CreateIssueRequest(

        @NotBlank
        long projectId,

        @NotBlank
        String title,

        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
        LocalDate startDate,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
        LocalDate endDate,
        Set<Long> assigneeIds,
        Set<Long> labelIds) {
}
