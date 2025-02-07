package com.issuetracker.application.issue.usecase;

import com.issuetracker.application.issue.data.command.ChangeIssueStatusCommand;
import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.service.IssueCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PatchIssueUseCase2 {

    private final IssueCommandService issueCommandService;

    public <T> Issue execute(T command) {
        if (command instanceof ChangeIssueStatusCommand) {

        }
        return null;
    }
}
