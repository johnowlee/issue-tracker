package com.issuetracker.application.project.data.command;

public record CreateProjectCommand(Long managerId, String title, String description) {
}
