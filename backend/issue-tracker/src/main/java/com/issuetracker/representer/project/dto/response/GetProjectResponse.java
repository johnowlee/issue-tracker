package com.issuetracker.representer.project.dto.response;

import com.issuetracker.representer.issue.dto.response.IssueDetailWithoutProjectResponse;

import java.util.List;

public record GetProjectResponse(
        ProjectResponse project,
        List<IssueDetailWithoutProjectResponse> issues) {
}
