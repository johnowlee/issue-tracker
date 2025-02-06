package com.issuetracker.representer.issue.dto.response;

import com.issuetracker.representer.user.dto.response.UserResponse;

import java.util.List;

public record CreateIssueResponse(

        IssueResponse issue,
        List<UserResponse> assignees) {
}
