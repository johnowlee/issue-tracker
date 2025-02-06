package com.issuetracker.application.project.usecase;

import com.issuetracker.application.project.data.command.CreateLabelCommand;
import com.issuetracker.core.project.domain.model.Label;
import com.issuetracker.core.project.domain.service.ProjectCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateLabelUseCase {

    private final ProjectCommandService projectCommandService;

    public Label execute(CreateLabelCommand command) {
        return projectCommandService.createLabel(command.labelName());
    }
}
