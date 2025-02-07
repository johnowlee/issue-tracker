package com.issuetracker.application.issue.usecase;

import com.issuetracker.application.issue.data.command.CreateIssueCommand;
import com.issuetracker.application.issue.mapper.IssueUseCaseMapper;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.service.IssueCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateIssueUseCase {

    private final IssueCommandService issueCommandService;
    private final IssueUseCaseMapper mapper;

    public Issue execute(CreateIssueCommand command) {
        return issueCommandService.create(mapper.toCreateIssueInfo(command));
    }
}
