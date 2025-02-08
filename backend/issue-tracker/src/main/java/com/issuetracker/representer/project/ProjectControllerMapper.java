package com.issuetracker.representer.project;

import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.application.project.data.command.DeleteProjectCommand;
import com.issuetracker.application.project.data.command.ModifyProjectCommand;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.common.CommonControllerMapper;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.request.DeleteProjectRequest;
import com.issuetracker.representer.project.dto.request.ModifyProjectRequest;
import com.issuetracker.representer.project.dto.response.ProjectDetailResponse;
import com.issuetracker.representer.project.dto.response.ProjectResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectControllerMapper extends CommonControllerMapper {

    public CreateProjectCommand toCreateProjectCommand(CreateProjectRequest request) {
        return new CreateProjectCommand(request.managerId(), request.title(), request.description());
    }

    public ProjectDetailResponse toProjectDetailResponse(Project project) {
        return new ProjectDetailResponse(
                toProjectResponse(project),
                project.getIssues().stream()
                        .map(this::toIssueDetailWithoutProjectResponse)
                        .toList()
        );
    }

    public ModifyProjectCommand toModifyProjectCommand(long id, ModifyProjectRequest request) {
        return new ModifyProjectCommand(id, request.userId(), request.title(), request.description());
    }

    public DeleteProjectCommand toDeleteProjectCommand(long id, DeleteProjectRequest request) {
        return new DeleteProjectCommand(id, request.userId());
    }

    public List<ProjectResponse> toProjectResponseList(List<Project> projects) {
        return projects.stream()
                .map(this::toProjectResponse)
                .toList();
    }

    public ProjectResponse toProjectResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getStartDate(),
                project.getEndDate()
        );
    }
}
