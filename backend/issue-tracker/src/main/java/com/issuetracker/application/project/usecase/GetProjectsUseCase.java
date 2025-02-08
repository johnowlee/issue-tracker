package com.issuetracker.application.project.usecase;

import com.issuetracker.core.project.domain.model.Project;
import com.issuetracker.core.project.domain.service.ProjectQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetProjectsUseCase {

    private final ProjectQueryService projectQueryService;

    public List<Project> execute() {
        return projectQueryService.getProjects();
    }
}
