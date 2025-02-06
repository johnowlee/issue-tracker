package com.issuetracker.representer.project.mapper;

import com.issuetracker.application.project.data.command.CreateIssueCommand;
import com.issuetracker.application.project.data.command.CreateLabelCommand;
import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.application.project.data.command.ModifyLabelCommand;
import com.issuetracker.core.project.domain.model.*;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.representer.project.dto.request.CreateIssueRequest;
import com.issuetracker.representer.project.dto.request.CreateLabelRequest;
import com.issuetracker.representer.project.dto.request.CreateProjectRequest;
import com.issuetracker.representer.project.dto.request.ModifyLabelRequest;
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

    public CreateLabelCommand toCreateLabelCommand(CreateLabelRequest request) {
        return new CreateLabelCommand(request.name());
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
                toAssigneeResponses(issue.getAssignees()),
                issue.getLabels().stream()
                        .map(IssueLabel::getLabel)
                        .map(this::toLabelResponse)
                        .collect(Collectors.toList()));
    }

    public GetProjectResponse toGetProjectResponse(Project project) {
        return new GetProjectResponse(
                toProjectResponse(project),
                project.getIssues().stream()
                        .map(this::toGetIssueWithoutProjectResponse)
                        .toList());
    }

    public LabelResponse toLabelResponse(Label label) {
        return new LabelResponse(label.getId(), label.getName());
    }

    public List<LabelResponse> toLabelsResponse(List<Label> labels) {
        return labels.stream()
                .map(this::toLabelResponse)
                .collect(Collectors.toList());
    }

    public ModifyLabelCommand toModifyLabelCommand(Long id, ModifyLabelRequest request) {
        return new ModifyLabelCommand(id, request.name());
    }

    private GetIssueWithoutProjectResponse toGetIssueWithoutProjectResponse(Issue issue) {
        return new GetIssueWithoutProjectResponse(
                toIssueResponse(issue),
                toAssigneeResponses(issue.getAssignees()));
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
