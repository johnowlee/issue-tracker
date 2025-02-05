package com.issuetracker.representer.project.dto.response;

import java.util.List;

public record GetProjectResponse(
        ProjectResponse project,
        List<GetIssueWithoutProjectResponse> issues) {
}
