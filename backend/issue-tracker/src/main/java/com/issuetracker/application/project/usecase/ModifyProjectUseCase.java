package com.issuetracker.application.project.usecase;

import com.issuetracker.application.project.data.command.ModifyProjectCommand;
import com.issuetracker.application.project.mapper.ProjectUseCaseMapper;
import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.service.ProjectCommandService;
import com.issuetracker.core.project.domain.service.dto.ModifyProjectInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModifyProjectUseCase {

    private final ProjectCommandService projectCommandService;
    private final ProjectUseCaseMapper projectUseCaseMapper;

    public Project execute(ModifyProjectCommand command) {
        ModifyProjectInfo info = projectUseCaseMapper.toModifyProjectInfo(command);
        return projectCommandService.modify(info);
    }
}
