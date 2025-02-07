package com.issuetracker.representer.issue.dto.response;

import com.issuetracker.representer.label.dto.response.LabelResponse;
import com.issuetracker.representer.user.dto.response.UserResponse;

import java.util.List;

public record IssueDetailWithoutProjectResponse(
        IssueResponse issue,
        List<UserResponse> assignees,
        List<LabelResponse> labels) {
}
