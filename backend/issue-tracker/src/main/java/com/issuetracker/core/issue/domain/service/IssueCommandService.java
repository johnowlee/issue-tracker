package com.issuetracker.core.issue.domain.service;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.model.IssueLabel;
import com.issuetracker.core.issue.domain.model.IssueUser;
import com.issuetracker.core.issue.domain.port.IssueCommandPort;
import com.issuetracker.core.issue.domain.service.dto.CreateIssueInfo;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.service.LabelQueryService;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.service.ProjectQueryService;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class IssueCommandService {

    private final IssueCommandPort issueCommandPort;
    private final ProjectQueryService projectQueryService;
    private final LabelQueryService labelQueryService;
    private final UserQueryService userQueryService;

    public Issue createIssue(CreateIssueInfo createIssueInfo) {
        Issue issue = Issue.create(createIssueInfo);
        Set<User> users = getUsers(createIssueInfo.assigneeIds());
        Set<Label> labels = getLabels(createIssueInfo.labelIds());
        Project project = projectQueryService.getProjectById(createIssueInfo.projectId());

        setRelations(issue, users, labels, project);

        return issueCommandPort.saveIssue(issue);
    }

    // TODO: 2025-02-06  예외처리
    private Set<User> getUsers(Set<Long> assigneeIds) {
        return assigneeIds.stream()
                .map(userQueryService::getUserById)
                .collect(Collectors.toSet());
    }

    private Set<Label> getLabels(Set<Long> labelIds) {
        return labelIds.stream()
                .map(labelQueryService::getLabelById)
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
