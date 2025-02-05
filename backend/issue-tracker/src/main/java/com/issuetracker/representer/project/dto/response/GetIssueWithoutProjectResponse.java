package com.issuetracker.representer.project.dto.response;

import com.issuetracker.representer.user.dto.response.UserResponse;

import java.util.List;

public record GetIssueWithoutProjectResponse(
        IssueResponse issue,
        List<UserResponse> assignees) {
}
