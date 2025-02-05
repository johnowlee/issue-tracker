package com.issuetracker.application.project.usecase;

import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.service.ProjectQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetProjectByIdUseCase {

    private final ProjectQueryService projectQueryService;

    public Project execute(long issueId) {
        return projectQueryService.getProjectById(issueId);
    }
}
