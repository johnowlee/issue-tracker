package com.issuetracker.representer.project.mapper;

import com.issuetracker.application.project.data.command.CreateIssueCommand;
import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.representer.project.dto.request.CreateIssueRequest;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.CreateIssueResponse;
import com.issuetracker.representer.project.dto.response.CreateProjectResponse;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ProjectControllerMapper {
    public CreateProjectCommand toCreateProjectCommand(CreateProjectRequest request) {
        return new CreateProjectCommand(request.managerId(), request.title(), request.description());
    }

    public CreateProjectResponse toCreateProjectResponse(Project project) {
        return new CreateProjectResponse(project.getId(), project.getManager().getId(), project.getTitle(), project.getDescription());
    }

    public CreateIssueCommand toCreateIssueCommand(CreateIssueRequest request, long projectId) {
        return new CreateIssueCommand(
                projectId, request.title(),
                request.description(),
                request.startDateTime(),
                request.endDateTime(),
                request.assigneeIds(),
                request.labelIds());
    }

    public CreateIssueResponse toCreateIssueResponse(Issue issue) {
        return new CreateIssueResponse(
                issue.getId(),
                issue.getProject().getId(),
                issue.getTitle(),
                issue.getDescription(),
                issue.getStartDateTime(),
                issue.getEndDateTime(),
                issue.getAssignees().stream()
                        .map(assignee -> assignee.getUser().getId())
                        .collect(Collectors.toSet()),
                null
        );
    }
}
