package com.issuetracker.core.project.domain.service;

import com.issuetracker.core.project.domain.model.Assignee;
import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectCommandPort;
import com.issuetracker.core.project.domain.service.dto.CreateIssueInfo;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
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
        Project project = projectQueryService.getProjectById(createIssueInfo.projectId());
        setIssueRelations(issue, users, project);
        return projectCommandPort.saveIssue(issue);
    }

    private Set<User> getUsers(Set<Long> assigneeIds) {
        return assigneeIds.stream()
                .map(userQueryService::getUserById)
                .collect(Collectors.toSet());
    }

    private static void setIssueRelations(Issue issue, Set<User> users, Project project) {
        for (User user : users) {
            Assignee.create(issue, user);
        }
        issue.setProject(project);
    }
}
