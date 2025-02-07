package com.issuetracker.application.issue.usecase;

import com.issuetracker.core.issue.domain.service.IssueCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DeleteIssueUseCase {

    private final IssueCommandService issueCommandService;

    public void execute(long id) {
        issueCommandService.delete(id);
    }
}
