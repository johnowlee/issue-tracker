package com.issuetracker.application.project.usecase;

import com.issuetracker.application.project.data.command.CreateProjectCommand;
import com.issuetracker.application.project.mapper.ProjectUseCaseMapper;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.service.ProjectCommandService;
import com.issuetracker.core.project.domain.service.dto.CreateProjectInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateProjectUseCase {

    private final ProjectCommandService projectCommandService;
    private final ProjectUseCaseMapper projectUseCaseMapper;

    public Project execute(CreateProjectCommand createProjectCommand) {
        CreateProjectInfo createProjectInfo = projectUseCaseMapper.toCreateProjectInfo(createProjectCommand);
        return projectCommandService.create(createProjectInfo);
    }
}
