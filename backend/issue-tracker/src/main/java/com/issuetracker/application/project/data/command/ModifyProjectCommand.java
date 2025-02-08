package com.issuetracker.application.project.data.command;

public record ModifyProjectCommand(long projectId, long userId, String title, String description) {
}
