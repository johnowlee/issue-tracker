package com.issuetracker.application.project.usecase;

import com.issuetracker.core.project.domain.service.ProjectCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteLabelUseCase {

    private final ProjectCommandService projectCommandService;

    public void execute(long id) {
        projectCommandService.deleteLabel(id);
    }
}
