package com.issuetracker.representer.project.mapper;

import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.CreateProjectResponse;
import org.springframework.stereotype.Component;

@Component
public class ProjectControllerMapper {
    public CreateProjectCommand toCreateProjectCommand(CreateProjectRequest request) {
        return new CreateProjectCommand(request.managerId(), request.title(), request.description());
    }

    public CreateProjectResponse toCreateProjectResponse(Project project) {
        return new CreateProjectResponse(project.getId(), project.getManager().getId(), project.getTitle(), project.getDescription());
    }
}
