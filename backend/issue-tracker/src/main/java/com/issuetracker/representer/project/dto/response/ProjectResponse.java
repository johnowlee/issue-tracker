package com.issuetracker.representer.project.dto.response;

import java.time.LocalDate;

public record ProjectResponse(
        long id,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate) {
}
