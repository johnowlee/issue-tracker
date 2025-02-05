package com.issuetracker.core.project.domain.service;

import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.port.ProjectCommandPort;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import com.issuetracker.core.user.domain.model.User;
import com.issuetracker.core.user.domain.service.UserQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectCommandService {

    private final ProjectCommandPort projectCommandPort;
    private final UserQueryService userQueryService;

    public Project createProject(CreateProjectInfo createProjectInfo) {
        User manager = userQueryService.getUserById(createProjectInfo.managerId());
        Project project = Project.from(createProjectInfo);
        project.setManager(manager);
        return projectCommandPort.save(project);
    }
}
