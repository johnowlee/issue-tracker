package com.issuetracker.application.project.usecase;

import com.issuetracker.application.project.data.command.ModifyLabelCommand;
import com.issuetracker.application.project.mapper.ProjectUseCaseMapper;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.service.ProjectCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModifyLabelUseCase {

    private final ProjectCommandService projectCommandService;
    private final ProjectUseCaseMapper mapper;

    public Label execute(ModifyLabelCommand command) {
        return projectCommandService.modifyLabel(mapper.toModifyLabelInfo(command));
    }
}
