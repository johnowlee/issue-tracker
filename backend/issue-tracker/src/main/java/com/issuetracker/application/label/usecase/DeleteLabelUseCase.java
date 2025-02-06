package com.issuetracker.application.label.usecase;

import com.issuetracker.core.label.domain.service.LabelCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteLabelUseCase {

    private final LabelCommandService labelCommandService;

    public void execute(long id) {
        labelCommandService.deleteLabel(id);
    }
}
