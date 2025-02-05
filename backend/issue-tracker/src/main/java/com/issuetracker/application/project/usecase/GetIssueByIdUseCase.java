package com.issuetracker.application.project.usecase;

import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.service.ProjectQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetIssueByIdUseCase {

    private final ProjectQueryService projectQueryService;

    public Issue execute(long issueId) {
        return projectQueryService.getIssueById(issueId);
    }
}
