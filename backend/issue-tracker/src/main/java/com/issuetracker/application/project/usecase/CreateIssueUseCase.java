package com.issuetracker.application.project.usecase;

import com.issuetracker.application.project.data.command.CreateIssueCommand;
import com.issuetracker.application.project.mapper.ProjectUseCaseMapper;
import com.issuetracker.core.project.domain.model.Issue;
import com.issuetracker.core.project.domain.service.ProjectCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateIssueUseCase {

    private final ProjectCommandService projectCommandService;
    private final ProjectUseCaseMapper projectUseCaseMapper;

    public Issue execute(CreateIssueCommand command) {
        return projectCommandService.createIssue(projectUseCaseMapper.toCreateIssueInfo(command));
    }
}
