package com.issuetracker.core.issue.domain.service;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.port.IssueQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class IssueQueryService {

    private final IssueQueryPort issueQueryPort;

    // TODO: 2025-02-05 예외처리
    public Issue getIssueById(long issueId) {
        return issueQueryPort.findIssueById(issueId)
                .orElseThrow(NoSuchElementException::new);
    }
}
