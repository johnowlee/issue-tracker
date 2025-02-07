package com.issuetracker.core.issue.infrastructure.adapter;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.port.IssueCommandPort;
import com.issuetracker.core.issue.infrastructure.repository.IssueJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IssueCommandAdapter implements IssueCommandPort {

    private final IssueJpaRepository issueJpaRepository;

    @Override
    public Issue save(Issue issue) {
        return issueJpaRepository.save(issue);
    }

    @Override
    public void delete(Issue issue) {
        issueJpaRepository.delete(issue);
    }
}
