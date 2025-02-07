package com.issuetracker.representer.project;

import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.common.CommonControllerMapper;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.CreateProjectResponse;
import com.issuetracker.representer.project.dto.response.GetProjectResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectControllerMapper extends CommonControllerMapper {

    public CreateProjectCommand toCreateProjectCommand(CreateProjectRequest request) {
        return new CreateProjectCommand(request.managerId(), request.title(), request.description());
    }

    public CreateProjectResponse toCreateProjectResponse(Project project) {
        return new CreateProjectResponse(toProjectResponse(project));
    }

    public GetProjectResponse toGetProjectResponse(Project project) {
        return new GetProjectResponse(
                toProjectResponse(project),
                project.getIssues().stream()
                        .map(this::toIssueDetailWithoutProjectResponse)
                        .toList()
        );
    }
}
