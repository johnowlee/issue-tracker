package com.issuetracker.representer.project.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.issuetracker.representer.user.dto.response.UserResponse;

import java.util.List;

public record GetIssueResponse(
        IssueResponse issue,
        ProjectResponse project,
        List<UserResponse> assignees) {
}
