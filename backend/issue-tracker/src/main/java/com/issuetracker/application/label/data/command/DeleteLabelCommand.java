package com.issuetracker.application.label.data.command;

public record DeleteLabelCommand(long labelId, long userId) {
}
