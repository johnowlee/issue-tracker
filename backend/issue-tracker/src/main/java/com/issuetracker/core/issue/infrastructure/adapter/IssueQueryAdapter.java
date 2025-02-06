package com.issuetracker.core.issue.infrastructure.adapter;

import com.issuetracker.core.issue.domain.model.Issue;
import com.issuetracker.core.issue.domain.port.IssueQueryPort;
import com.issuetracker.core.issue.infrastructure.repository.IssueJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class IssueQueryAdapter implements IssueQueryPort {

    private final IssueJpaRepository issueJpaRepository;

    @Override
    public Optional<Issue> findIssueById(Long id) {
        return issueJpaRepository.findById(id);
    }
}
