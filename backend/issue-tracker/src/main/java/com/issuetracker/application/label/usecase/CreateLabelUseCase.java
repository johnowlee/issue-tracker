package com.issuetracker.application.label.usecase;

import com.issuetracker.application.label.data.command.CreateLabelCommand;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.service.LabelCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateLabelUseCase {

    private final LabelCommandService labelCommandService;

    public Label execute(CreateLabelCommand command) {
        return labelCommandService.createLabel(command.labelName());
    }
}
