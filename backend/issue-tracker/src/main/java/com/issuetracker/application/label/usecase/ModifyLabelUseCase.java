package com.issuetracker.application.label.usecase;

import com.issuetracker.application.label.data.command.ModifyLabelCommand;
import com.issuetracker.application.label.mapper.LabelUseCaseMapper;
import com.issuetracker.core.label.domain.model.Label;
import com.issuetracker.core.label.domain.service.LabelCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModifyLabelUseCase {

    private final LabelCommandService labelCommandService;
    private final LabelUseCaseMapper mapper;

    public Label execute(ModifyLabelCommand command) {
        return labelCommandService.modifyLabel(mapper.toModifyLabelInfo(command));
    }
}
