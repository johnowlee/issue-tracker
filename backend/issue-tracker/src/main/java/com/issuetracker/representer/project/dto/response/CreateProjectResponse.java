package com.issuetracker.representer.project.dto.response;

public record CreateProjectResponse(long projectId, long managerId, String title, String description) {
}