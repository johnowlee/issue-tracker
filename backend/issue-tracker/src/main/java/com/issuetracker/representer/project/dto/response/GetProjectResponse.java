package com.issuetracker.representer.project.dto.response;

import com.issuetracker.representer.issue.dto.response.IssueDetailResponse;

import java.util.List;

public record GetProjectResponse(
        ProjectResponse project,
        List<IssueDetailResponse> issues) {
}
