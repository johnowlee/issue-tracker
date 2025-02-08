package com.issuetracker.core.project.domain.service.dto;

public record ModifyProjectInfo(long projectId, long userId, String title, String description) {
}
