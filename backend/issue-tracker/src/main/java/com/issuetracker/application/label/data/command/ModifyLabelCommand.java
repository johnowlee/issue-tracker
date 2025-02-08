package com.issuetracker.application.label.data.command;

public record ModifyLabelCommand(long labelId, String name, long userId) {
}
