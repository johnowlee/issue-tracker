package com.issuetracker.application.project.data.command;

public record DeleteProjectCommand(long projectId, long userId) {
}
