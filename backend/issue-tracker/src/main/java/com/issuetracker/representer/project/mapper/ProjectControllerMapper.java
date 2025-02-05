package com.issuetracker.representer.project.mapper;

import com.issuetracker.application.project.data.command.CreateIssueCommand;
import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.IssueUser;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.representer.project.dto.request.CreateIssueRequest;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.response.*;
import com.issuetracker.representer.user.dto.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProjectControllerMapper {
    public ProjectResponse toProjectResponse(Project project) {
        return new ProjectResponse(project.getId(), project.getTitle(), project.getDescription(), project.getStartDateTime(), project.getEndDateTime());
    }

    public IssueResponse toIssueResponse(Issue issue) {
        return new IssueResponse(issue.getId(), issue.getTitle(), issue.getDescription(), issue.getStartDateTime(), issue.getEndDateTime(), issue.getStatus());
    }

    public CreateProjectCommand toCreateProjectCommand(CreateProjectRequest request) {
        return new CreateProjectCommand(request.managerId(), request.title(), request.description());
    }

    public CreateProjectResponse toCreateProjectResponse(Project project) {
        return new CreateProjectResponse(toProjectResponse(project));
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
                toIssueResponse(issue),
                toAssigneeResponses(issue.getAssignees()));
    }

    public GetIssueResponse toGetIssueResponse(Issue issue) {
        return new GetIssueResponse(
                toIssueResponse(issue),
                toProjectResponse(issue.getProject()),
                toAssigneeResponses(issue.getAssignees()));
    }

    public GetProjectResponse toGetProjectResponse(Project project) {
        return new GetProjectResponse(
                toProjectResponse(project),
                project.getIssues().stream()
                        .map(this::toGetIssueResponse)
                        .toList()
        );
    }

    private static List<UserResponse> toAssigneeResponses(Set<IssueUser> issueUsers) {
        return issueUsers.stream()
                .map(IssueUser::getUser)
                .map(ProjectControllerMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    private static UserResponse toUserResponse(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getEmail());
    }
}
