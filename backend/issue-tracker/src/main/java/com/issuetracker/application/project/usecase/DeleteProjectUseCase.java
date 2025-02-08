package com.issuetracker.application.project.usecase;

import com.issuetracker.application.project.data.command.DeleteProjectCommand;
import com.issuetracker.application.project.mapper.ProjectUseCaseMapper;
import com.issuetracker.core.project.domain.service.ProjectCommandService;
import com.issuetracker.core.project.domain.service.dto.DeleteProjectInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteProjectUseCase {

    private final ProjectCommandService projectCommandService;
    private final ProjectUseCaseMapper projectUseCaseMapper;

    public void execute(DeleteProjectCommand command) {
        DeleteProjectInfo info = projectUseCaseMapper.toDeleteProjectInfo(command);
        projectCommandService.delete(info);
    }
}
