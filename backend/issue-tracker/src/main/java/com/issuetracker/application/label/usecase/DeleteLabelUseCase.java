package com.issuetracker.application.label.usecase;

import com.issuetracker.application.label.data.command.DeleteLabelCommand;
import com.issuetracker.application.label.mapper.LabelUseCaseMapper;
import com.issuetracker.core.label.domain.service.LabelCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteLabelUseCase {

    private final LabelCommandService labelCommandService;
    private final LabelUseCaseMapper labelUseCaseMapper;

    public void execute(DeleteLabelCommand command) {
        labelCommandService.deleteLabel(labelUseCaseMapper.toDeleteLabelInfo(command));
    }
}
