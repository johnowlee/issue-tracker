package com.issuetracker.application.issue.usecase;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.service.IssueQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GetIssueByIdUseCase {

    private final IssueQueryService issueQueryService;

    public Issue execute(long issueId) {
        return issueQueryService.getIssueById(issueId);
    }
}
