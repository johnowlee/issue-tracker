package com.issuetracker.representer.project.dto.response;

import java.time.LocalDateTime;

public record ProjectResponse(
        long id,
        String title,
        String description,
        LocalDateTime startDateTime,
        LocalDateTime endDateTime) {
}
