package com.issuetracker.core.issue.domain.service;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.port.IssueCommandPort;
import com.issuetracker.core.issue.domain.service.dto.*;
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
    private final IssueQueryService issueQueryService;
    private final ProjectQueryService projectQueryService;
    private final LabelQueryService labelQueryService;
    private final UserQueryService userQueryService;

    private final IssueRelationManager issueRelationManager;

    public Issue create(CreateIssueInfo info) {
        Project project = projectQueryService.getProjectById(info.projectId());
        User user = userQueryService.getUserById(info.userId());
        validateProjectManager(user, project);

        Issue issue = Issue.create(info);
        Set<User> users = getUsers(info.assigneeIds());
        Set<Label> labels = getLabels(info.labelIds());

        issueRelationManager.relateIssueUsers(issue, users);
        issueRelationManager.relateIssueLabels(issue, labels);
        issueRelationManager.relateIssueProject(issue, project);

        return issueCommandPort.save(issue);
    }

    public Issue modify(ModifyIssueInfo info) {
        Issue issue = issueQueryService.getIssueById(info.userId());
        User user = userQueryService.getUserById(info.userId());
        Project project = issue.getProject();

        validateProjectManager(user, project);

        issue.updateTitle(info.title());
        issue.updateDescription(info.description());
        issue.updateStartDate(info.startDate());
        issue.updateEndDate(info.endDate());
        project.updateProjectPeriod();
        return issue;
    }

    public void delete(DeleteIssueInfo info) {
        Issue issue = issueQueryService.getIssueById(info.issueId());

        User user = userQueryService.getUserById(info.userId());
        validateProjectManager(user, issue.getProject());

        issueCommandPort.delete(issue);
    }

    public Issue changeStatus(ChangeIssueStatusInfo info) {
        Issue issue = issueQueryService.getIssueById(info.userId());
        User user = userQueryService.getUserById(info.userId());

        validateProjectManager(user, issue.getProject());

        issue.changeStatus(info.status());
        return issue;
    }

    public Issue modifyLabels(ModifyIssueLabelsInfo info) {
        Issue issue = issueQueryService.getIssueById(info.issueId());
        User user = userQueryService.getUserById(info.userId());

        validateProjectManager(user, issue.getProject());

        Set<Label> labels = getLabels(info.labelIds());

        issueRelationManager.updateIssueLabelRelations(issue, labels);

        return issue;
    }

    public Issue modifyAssignees(ModifyIssueAssigneesInfo info) {
        Issue issue = issueQueryService.getIssueById(info.issueId());
        User user = userQueryService.getUserById(info.userId());

        validateProjectManager(user, issue.getProject());

        Set<User> assignees = getUsers(info.assigneeIds());

        issueRelationManager.updateIssueUserRelations(issue, assignees);

        return issue;
    }

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

    private static void validateProjectManager(User user, Project project) {
        // TODO: 2025-02-08
        if (!user.equals(project.getManager())) {
            throw new IllegalArgumentException("프로젝트 관리자가 아닙니다.");
        }
    }
}
