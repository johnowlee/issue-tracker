package com.issuetracker.application.issue.data.command;

public record DeleteIssueCommand(long issueId, long userId) {
}
