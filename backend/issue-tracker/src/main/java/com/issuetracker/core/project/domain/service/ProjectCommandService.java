package com.issuetracker.core.project.domain.service;

import com.issuetracker.core.project.domain.model.*;
import com.issuetracker.core.project.domain.port.ProjectCommandPort;
import com.issuetracker.core.project.domain.service.dto.CreateIssueInfo;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserQueryService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectCommandService {

    private final ProjectCommandPort projectCommandPort;
    private final ProjectQueryService projectQueryService;
    private final UserQueryService userQueryService;

    public Project createProject(CreateProjectInfo createProjectInfo) {
        User manager = userQueryService.getUserById(createProjectInfo.managerId());
        Project project = Project.from(createProjectInfo);
        project.setManager(manager);
        return projectCommandPort.saveProject(project);
    }

    public Issue createIssue(CreateIssueInfo createIssueInfo) {
        Issue issue = Issue.create(createIssueInfo);
        Set<User> users = getUsers(createIssueInfo.assigneeIds());
        Set<Label> labels = getLabels(createIssueInfo.labelIds());
        Project project = projectQueryService.getProjectById(createIssueInfo.projectId());

        setRelations(issue, users, labels, project);

        return projectCommandPort.saveIssue(issue);
    }

    // TODO: 2025-02-06  예외처리
    public Label createLabel(String labelName) {
        if (projectQueryService.isLabelPresentByName(labelName)) {
            throw new EntityExistsException();
        }
        Label label = Label.create(labelName);
        return projectCommandPort.saveLabel(label);
    }

    private Set<User> getUsers(Set<Long> assigneeIds) {
        return assigneeIds.stream()
                .map(userQueryService::getUserById)
                .collect(Collectors.toSet());
    }

    private Set<Label> getLabels(Set<Long> labelIds) {
        return labelIds.stream()
                .map(projectQueryService::getLabelById)
                .collect(Collectors.toSet());
    }

    private static void setRelations(Issue issue, Set<User> users, Set<Label> labels, Project project) {
        users.forEach(user -> {
            IssueUser issueUser = IssueUser.create();
            issueUser.setIssue(issue);
            issueUser.setUser(user);
        });

        labels.forEach(label -> {
            IssueLabel issueLabel = IssueLabel.create();
            issueLabel.setIssue(issue);
            issueLabel.setLabel(label);
        });

        issue.setProject(project);
        project.updateProjectPeriod();
    }
}
