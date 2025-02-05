package com.issuetracker.application.user.data.command;

public record CreateUserCommand(String name, String email, String password) {
}