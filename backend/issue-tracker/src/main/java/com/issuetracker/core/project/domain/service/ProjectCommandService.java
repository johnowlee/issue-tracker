package com.issuetracker.core.project.domain.service;

import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectCommandPort;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.project.domain.service.dto.DeleteProjectInfo;
import com.issuetracker.core.project.domain.service.dto.ModifyProjectInfo;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProjectCommandService {

    private final ProjectCommandPort projectCommandPort;
    private final ProjectQueryService projectQueryService;
    private final UserQueryService userQueryService;

    private final ProjectValidator projectValidator;

    public Project create(CreateProjectInfo info) {
        User manager = userQueryService.getUserById(info.managerId());
        Project project = Project.from(info);
        project.setManager(manager);
        return projectCommandPort.saveProject(project);
    }

    public Project modify(ModifyProjectInfo info) {
        Project project = projectQueryService.getProjectById(info.projectId());
        User user = userQueryService.getUserById(info.userId());
        projectValidator.validateManager(project, user);

        project.updateTitle(info.title());
        project.updateDescription(info.description());

        return project;
    }

    public void delete(DeleteProjectInfo info) {
        Project project = projectQueryService.getProjectById(info.projectId());
        User user = userQueryService.getUserById(info.userId());
        projectValidator.validateManager(project, user);
        projectCommandPort.delete(project);
    }
}
